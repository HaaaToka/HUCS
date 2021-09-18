`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   21:12:12 11/04/2017
// Design Name:   mymodule02
// Module Name:   D:/xilinxISE/xilinxProject/week2/mymodule02_tb.v
// Project Name:  week2
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: mymodule02
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module mymodule02_tb;

	// Inputs
	reg A;
	reg B;
	reg Cin;

	// Outputs
	wire [0:4] O;

	// Instantiate the Unit Under Test (UUT)
	mymodule02 uut (
		.O(O), 
		.A(A), 
		.B(B), 
		.Cin(Cin)
	);

	initial begin
		// Initialize Inputs
		A = 0;
		B = 0;
		Cin = 0;

		// Wait 100 ns for global reset to finish
		#20;
        
		// Add stimulus here
		A = 0;
		B = 1;
		Cin = 0;
		#40;
		
		A = 1;
		B = 0;
		Cin = 0;
		#60;
		
		A = 1;
		B = 1;
		Cin = 0;
		#80;
		
		A = 0;
		B = 0;
		Cin = 1;
		#100;
		
		A = 0;
		B = 1;
		Cin = 1;
		#120;
		
		A = 1;
		B = 0;
		Cin = 1;
		#140;
		
		A = 1;
		B = 1;
		Cin = 1;
		#160;
		
	end
      
			initial begin
	$monitor("A=%d, B=%d , Cin=%d , S=%d, Cout=%d",A,B,Cin,O[1],O[4]);
   end

		
endmodule

