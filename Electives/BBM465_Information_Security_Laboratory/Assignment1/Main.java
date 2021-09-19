import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static byte[] for_exor_init_vector = null;
	/*for run.log*/
	public static void appendStrToFile(String fileName, String str) {
		try {
			// Open given file in append mode. 
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
			out.write(str);
			out.close();
		} catch (IOException e) {
			System.out.println("exception occoured" + e);
		}
	}

	/**
	 * This method uses java.io.FileInputStream to read file content into a byte
	 * array
	 * 
	 * @param file
	 * @return
	 */
	private static byte[] readFileToByteArray(File file) {
		FileInputStream fis = null;
		// Creating a byte array using the length of the file
		// file.length returns long which is cast to int
		byte[] bArray = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();

		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		}
		return bArray;
	}

	/* function to reads files */
	public static ArrayList<String> read_file(String file_name) {
		ArrayList<String> file_lines = new ArrayList<String>();
		try {
			// the file to be opened for reading
			FileInputStream fis = new FileInputStream(file_name);
			Scanner sc = new Scanner(fis); // file to be scanned
			// returns true if there is another line to read
			while (sc.hasNextLine()) {
				file_lines.add(sc.nextLine());
			}
			sc.close(); // closes the scanner
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file_lines;
	}

	/* returns the last letters of the word as the number entered by the user */
	public static String last(String word, int bytes) {
		return word.substring(word.length() - bytes, word.length());
	}

	/* sets all words to be encrypted */
	public static ArrayList<String> splitter(ArrayList<String> infile, int bytes) {
		ArrayList<String> words = new ArrayList<String>();
		for (int i = 0; i < infile.size(); i++) {
			for (int j = 0; j < infile.get(i).length(); j += bytes) {
				if (j + bytes < infile.get(i).length()) {
					words.add(infile.get(i).substring(j, j + bytes));
				} else {
					// if size not enough, add space end of word
					String need_space = infile.get(i).substring(j, infile.get(i).length());
					for (int k = 0; k < j + bytes - infile.get(i).length(); k++) {
						need_space += " ";
					}
					words.add(need_space);
				}
			}
		}
		return words;
	}

	/* Program starts */
	public static void main(String[] args) throws IOException {
		Instant start = Instant.now();
		String for_writer2 = args[2] + " " + args[4];
		/* public encryption object */
		Object algorithm;
		/**/
		ArrayList<String> infile = null;
		byte[] b_array = null;
		File file = null;
		BufferedWriter writer = null;
		/* read input string lines */
		if (args[1].equals("-i") && args[0].equals("-e")) {
			for_writer2 += " enc ";
			infile = read_file(args[2]);
		}
		/* read input byte lines */
		if (args[1].equals("-i") && args[0].equals("-d")) {
			for_writer2 += " dec ";
			b_array = readFileToByteArray(new File(args[2]));
		}
		/* create output file for encryption */
		if (args[3].equals("-o") && args[0].equals("-e")) {
			file = new File(args[4]);
		}
		/* create output file for decryption */
		if (args[3].equals("-o") && args[0].equals("-d")) {
			writer = new BufferedWriter(new FileWriter(args[4]));
		}
		/* read key file */
		ArrayList<String> key_file = read_file(args[7]);
		// IV - K - Nonce --> split key file data
		String[] splitted_key_file = key_file.get(0).split(" - ");

		/* AES PART */
		if (args[5].equals("AES")) {
			algorithm = new AesFinal();
			OutputStream os = null;
			//set inputs lengths
			String last_16_IV = last(splitted_key_file[0], 16);
			String last_16_key = last(splitted_key_file[1], 16);
			String last_8_nonce = last(splitted_key_file[2], 8);
			for_exor_init_vector = last_16_IV.getBytes("UTF-8");
			if (args[6].equals("CBC")) {
				if (args[0].equals("-e")) {
					//writes byte[] in file
					os = new FileOutputStream(file);
					ArrayList<String> words = splitter(infile, 16);
					for (String word : words) {
						//encryption every words
						byte[] cipher_text = ((AesFinal) algorithm).encrypt_CBC(word, last_16_key,for_exor_init_vector);
						//writes bytes in file
						os.write(cipher_text);
						for_exor_init_vector = cipher_text;
					}

				} else if (args[0].equals("-d")) {
					// byte[] Cipher_text, String key, String IV

					for (int i = 0; i < b_array.length; i += 16) {
						//split byte[] array
						byte[] slice = Arrays.copyOfRange(b_array, i, i + 16);
						//decryption every bytes
						String result = ((AesFinal) algorithm).decrypt_CBC(slice, last_16_key, for_exor_init_vector);
						//writes bytes in file
						writer.append(result);
					}

				}
			}

			else if (args[6].equals("OFB")) {
				if (args[0].equals("-e")) {
					os = new FileOutputStream(file);
					ArrayList<String> words = splitter(infile, 16);
					for (String word : words) {
						//encryption every words
						byte[] cipher_text = ((AesFinal) algorithm).encrypt_OFB(word, last_16_key,for_exor_init_vector);
						//writes bytes in file
						os.write(cipher_text);
					}

				} else if (args[0].equals("-d")) {
					for (int i = 0; i < b_array.length; i += 16) {
						//split byte[] array
						byte[] slice = Arrays.copyOfRange(b_array, i, i + 16);
						//decryption every bytes
						String result = ((AesFinal) algorithm).decrypt_OFB(slice, last_16_key, for_exor_init_vector);
						//writes words in file
						writer.append(result);
					}
				}

			}

			else if (args[6].equals("CTR")) {
				String nonce = splitted_key_file[0];
				if (args[0].equals("-e")) {
					os = new FileOutputStream(file);
					ArrayList<String> words = splitter(infile, 16);
					for (String word : words) {
						//encryption every words
						byte[] cipher_text = ((AesFinal) algorithm).encrypt_CTR(word, last_16_key, last_8_nonce);
						//writes bytes in file
						os.write(cipher_text);
					}

				} else if (args[0].equals("-d")) {
					for (int i = 0; i < b_array.length; i += 16) {
						//split byte[] array
						byte[] slice = Arrays.copyOfRange(b_array, i, i + 16);
						//decryption every bytes
						String result = ((AesFinal) algorithm).decrypt_CTR(slice, last_16_key, last_8_nonce);
						//writes words in file
						writer.append(result);
					}
				}
			}
			if (os != null) {
				os.close();
			}
		}
		/* DES PART */
		if (args[5].equals("DES")) {
			algorithm = new DESfinal();
			OutputStream os = null;

			// fix lenght for keysize
			String last_8_IV = last(splitted_key_file[0], 8);
			String last_8_key = last(splitted_key_file[1], 8);
			String last_7_nonce = last(splitted_key_file[2], 7);
			for_exor_init_vector = last_8_IV.getBytes("UTF-8");

			if (args[6].equals("CBC")) {

				if (args[0].equals("-e")) {
					os = new FileOutputStream(file);
					ArrayList<String> words = splitter(infile, 8);

					for (String word : words) {
						//encryption every words
						byte[] cipher_text = ((DESfinal) algorithm).encrypt_CBC(word, last_8_key, for_exor_init_vector);
						//writes bytes in file
						os.write(cipher_text);
						for_exor_init_vector = cipher_text;
					}

				} else if (args[0].equals("-d")) {
					for (int i = 0; i < b_array.length; i += 8) {
						//split byte[] array
						byte[] slice = Arrays.copyOfRange(b_array, i, i + 8);
						//decryption every bytes
						String result = ((DESfinal) algorithm).decrypt_CBC(slice, last_8_key, for_exor_init_vector);
						//writes words in file
						writer.append(result);
					}

				}
			}

			else if (args[6].equals("OFB")) {
				if (args[0].equals("-e")) {
					os = new FileOutputStream(file);
					ArrayList<String> words = splitter(infile, 8);
					for (String word : words) {
						//encryption every words
						byte[] cipher_text = ((DESfinal) algorithm).encrypt_OFB(word, last_8_key, for_exor_init_vector);
						//writes bytes in file
						os.write(cipher_text);
					}

				} else if (args[0].equals("-d")) {
					for (int i = 0; i < b_array.length; i += 8) {
						//split byte[] array
						byte[] slice = Arrays.copyOfRange(b_array, i, i + 8);
						//decryption every bytes
						String result = ((DESfinal) algorithm).decrypt_OFB(slice, last_8_key, for_exor_init_vector);
						//writes words in file
						writer.append(result);
					}
				}

			}

			else if (args[6].equals("CTR")) {

				if (args[0].equals("-e")) {
					os = new FileOutputStream(file);
					ArrayList<String> words = splitter(infile, 8);
					for (String word : words) {
						//encryption every words
						byte[] cipher_text = ((DESfinal) algorithm).encrypt_CTR(word, last_8_key, last_7_nonce);
						//writes bytes in file
						os.write(cipher_text);
					}

				} else if (args[0].equals("-d")) {
					for (int i = 0; i < b_array.length; i += 8) {
						//split byte[] array
						byte[] slice = Arrays.copyOfRange(b_array, i, i + 8);
						//decryption every bytes
						String result = ((DESfinal) algorithm).decrypt_CTR(slice, last_8_key, last_7_nonce);
						//writes words in file
						writer.append(result);
					}
				}
			}
			if (os != null) {
				os.close();
			}
		}
		if (writer != null) {
			writer.close();
		}
		//timer
		Instant end = Instant.now();
		//timer calculater
		Duration timeElapsed = Duration.between(start, end);
		
		//for run.log
		for_writer2 += args[5] + " " + args[6] + " " + timeElapsed.toMillis()+"\n";
		appendStrToFile("run.log",for_writer2);
		System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
		System.out.println("The program is over");

	}

}
