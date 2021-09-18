`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   21:28:57 12/31/2017
// Design Name:   ram
// Module Name:   D:/xilinxISE/xilinxProject/hw6/tb_ram.v
// Project Name:  hw6
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: ram
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module tb_ram;

	// Inputs
	reg [1:0] a;
	reg wr;
	reg Din;
	reg Rd;
	reg Dout;

	// Instantiate the Unit Under Test (UUT)
	ram uut (
		.a(a), 
		.wr(wr), 
		.Din(Din), 
		.Rd(Rd), 
		.Dout(Dout)
	);

	initial begin
		// Initialize Inputs
		a = 0;
		wr = 0;
		Din = 0;
		Rd = 0;
		Dout = 0;

		// Wait 100 ns for global reset to finish
		#100;
        
		// Add stimulus here

	end
      
endmodule

