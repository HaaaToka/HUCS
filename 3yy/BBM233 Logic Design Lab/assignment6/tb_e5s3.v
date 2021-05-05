`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   21:03:13 12/17/2017
// Design Name:   e5s3
// Module Name:   D:/xilinxISE/xilinxProject/week5/tb_e5s3.v
// Project Name:  week5
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: e5s3
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module tb_e5s3;

	// Inputs
	reg clck;


	//Outputs
	wire out;

	// Instantiate the Unit Under Test (UUT)
	e5s3 uut (
		.clck(clck),
		.out
	);
	
   initial begin
	clck=1'b1;
	forever #10 clck=~clck;
	end

	initial begin
		$monitor("C",out);
	end

      
endmodule

