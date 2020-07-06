`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    20:52:03 11/04/2017 
// Design Name: 
// Module Name:    mymodule01 
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
module mymodule01(O,A,B,mode);
	
	output[0:2] O;
	input A,B,mode;
	
	xor G1(O[0],A,B);
	xor G2(O[1],A,mode);
	and G3(O[2],B,O[1]);

endmodule
