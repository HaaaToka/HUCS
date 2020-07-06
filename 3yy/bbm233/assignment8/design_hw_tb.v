`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   22:30:53 01/20/2018
// Design Name:   primeCounter
// Module Name:   D:/xilinxISE/xilinxProject/hv2018/tb_primeCounter.v
// Project Name:  hv2018
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: primeCounter
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module tb_primeCounter;

	// Inputs
	reg x;
	reg clk;

	// Outputs
	wire [3:0] ot;

	// Instantiate the Unit Under Test (UUT)
	primeCounter uut (
		.x(x), 
		.ot(ot), 
		.clk(clk)
	);

	initial begin
		x = 1;
		clk = 0;
		
		#100;
	end
      
		always #10 clk=~clk;
	
	initial begin
		$monitor("output %b",ot[3:0]);
	end
		
endmodule

