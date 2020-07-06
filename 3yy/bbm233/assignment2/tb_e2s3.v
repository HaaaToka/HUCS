`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   20:52:52 11/04/2017
// Design Name:   mymodule01
// Module Name:   D:/xilinxISE/xilinxProject/week2/mymodule01_tb.v
// Project Name:  week2
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
	reg mode;

	// Outputs
	wire [0:2] O;

	// Instantiate the Unit Under Test (UUT)
	mymodule01 uut (
		.O(O), 
		.A(A), 
		.B(B), 
		.mode(mode)
	);

	initial begin
		// Initialize Inputs
		A = 0;
		B = 0;
		mode = 0;

		// Wait 100 ns for global reset to finish
		#20;
        
		// Add stimulus here

		A=0;
		B=1;
		mode=0;
		#40;
		
		A=1;
		B=0;
		mode=0;
		#60;
		
		A=1;
		B=1;
		mode=0;
		#80;
		
		A=0;
		B=0;
		mode=1;
		#100;
		
		A=0;
		B=1;
		mode=1;
		#120;
		
		A=1;
		B=0;
		mode=1;
		#140;
		
		A=1;
		B=1;
		mode=1;
		#160;

	end
      	initial begin
	$monitor("A=%d, B=%d , mode=%d , Sum/Diff=%d, Carry/Borrow",A,B,mode,O[0],O[2]);
   end

endmodule

