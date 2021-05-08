`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    00:20:25 11/30/2017 
// Design Name: 
// Module Name:    fourbitadder 
// Project Name: 
// Target Devices: 
// Tool versions: 
// Description: 
//
// Dependencies: 
//
// Revision: 
// Revision 0.01 - File Created
// Additional Comments: 
//
//////////////////////////////////////////////////////////////////////////////////
module halfadder(
	input a,
	input b,
	output s,
	output cout
	);
	
	xor(s,a,b);
	and(cout,a,b);
	
endmodule

module fulladder(
	input a,
	input b,
	input cin,
	output s,
	output cout
	);
	
	halfadder ha0( .a(a), .b(b), .s(ss1), .cout(cc1) );
	halfadder ha1( .a(cin), .b(ss1), .s(s), .cout(cc2) );
	
	or(cout,ha0.cout,ha1.cout);
	
endmodule


module fourbitadder(
    input [0:3] a,
    input [0:3] b,
	 input cin,
    output [0:3] sum,
    output carry
    );

	//assign cin = 0;
	
	fulladder fa0( .a(a[0]), .b(b[0]), .cin(cin), .s(sum[0]), .cout(ripple0) );
	fulladder fa1( .a(a[1]), .b(b[1]), .cin(ripple0), .s(sum[1]), .cout(ripple1) );
	fulladder fa2( .a(a[2]), .b(b[2]), .cin(ripple1), .s(sum[2]), .cout(ripple2) );
	fulladder fa3( .a(a[3]), .b(b[3]), .cin(ripple2), .s(sum[3]), .cout(carry) );


endmodule
