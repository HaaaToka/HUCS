`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    12:59:20 10/22/2017 
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
module mymodule01(D,A,B,C );
	output[0:5] D;
	input A,B,C;
	wire A_n,B_n,C_n,snc_n;
	
	not G1(A_n,A);
	not G2(B_n,B);

	
	and G3(D[0],A,B_n);
	and G4(D[1],A_n,B);
	or G5(D[2],D[0],D[1]);
	
	not G6(snc_n,D[2]);
	not G7(C_n,C);
	
	and G8(D[3],D[2],C_n);
	and G9(D[4],snc_n,C);
	or G10(D[5],D[3],D[4]);


endmodule
