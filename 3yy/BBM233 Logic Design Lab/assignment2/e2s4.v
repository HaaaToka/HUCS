`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    21:00:00 11/04/2017 
// Design Name: 
// Module Name:    mymodule02 
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
module mymodule02(O,A,B,Cin);
	
	output[0:4] O;
	input A,B,Cin;
	
	xor G1(O[0],A,B);
	xor G2(O[1],O[0],Cin);
	
	and G3(O[2],Cin,O[0]);
	and G4(O[3],A,B);

	or G5(O[4],O[2],O[3]);

endmodule
