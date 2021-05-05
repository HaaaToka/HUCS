`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   20:14:33 12/10/2017
// Design Name:   e4s1
// Module Name:   D:/xilinxISE/xilinxProject/weekfour/tb_e4s1.v
// Project Name:  weekfour
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: e4s1
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module tb_e4s1;

	// Inputs
	reg J;
	reg clock;

	// Outputs
	wire [0:3] Out;

	// Instantiate the Unit Under Test (UUT)
	e4s1 uut (
		.J(J), 
		.clock(clock), 
		.Out(Out)
	);
	initial begin
	clock=1'b1;
	forever #10 clock=~clock;
	end


	initial begin
	
		J = 0;
		#20;
		
		J = 1;
		#20;

	end
	
	initial begin
	$monitor("J=%d, out0=%d , out1=%d ",J,Out[0],Out[2]);
   end
      
endmodule

