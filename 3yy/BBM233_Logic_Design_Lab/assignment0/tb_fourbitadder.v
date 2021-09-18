`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   00:21:45 11/30/2017
// Design Name:   fourbitadder
// Module Name:   D:/xilinxISE/xilinxProject/fckingcircuit/tb_fourbitadder.v
// Project Name:  fckingcircuit
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: fourbitadder
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module tb_fourbitadder;

	// Inputs
	reg [0:3] a;
	reg [0:3] b;
	reg cin;

	// Outputs
	wire [0:3] sum;
	wire carry;
	
	//vars
	integer i;

	// Instantiate the Unit Under Test (UUT)
	fourbitadder uut (
		.a(a), 
		.b(b), 
		.cin(cin), 
		.sum(sum), 
		.carry(carry)
	);

	initial begin
		// Initialize Inputs
		a = 0;
		b = 0;
		cin = 0;
	end
	
	initial
			$monitor("a(%b) + b(%b) = carry sum(%b  %b)",a,b,carry,sum);

		always @(a or b)
				begin
				for(i=0; i< 16*16; i=i+1)
					#1 {a,b} = i;
				end

	
endmodule

