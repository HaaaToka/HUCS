`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   13:48:14 10/22/2017
// Design Name:   mymodule01
// Module Name:   D:/xilinxISE/xilinxProject/week1/mymodule01_tb.v
// Project Name:  week1
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: mymodule01
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module mymodule01_tb;

	// Inputs
	reg A;
	reg B;
	reg C;

	// Outputs
	wire [0:5] D;

	// Instantiate the Unit Under Test (UUT)
	mymodule01 uut (
		.D(D), 
		.A(A), 
		.B(B), 
		.C(C)
	);

	initial begin
		// Initialize Inputs
		A = 0;
		B = 0;
		C = 0;

		// Wait 100 ns for global reset to finish
		#20;
        
		// Add stimulus here
		A = 0;
		B = 0;
		C = 1;
		#40;
		
		A = 0;
		B = 1;
		C = 0;
		#80;
		
		A = 0;
		B = 1;
		C = 1;
		#100;
		
		A = 1;
		B = 0;
		C = 0;
		#120;
		
		A = 1;
		B = 0;
		C = 1;
		#140;
		
		A = 1;
		B = 1;
		C = 0;
		#160;
		
		A = 1;
		B = 1;
		C = 1;
		#180;
				
	end
	
	initial begin
	$monitor("A=%d, B=%d , C=%d , sonuc=%d",A,B,C,D[5]);
   end
endmodule

