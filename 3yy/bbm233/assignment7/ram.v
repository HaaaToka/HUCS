`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    14:14:16 12/30/2017 
// Design Name: 
// Module Name:    ram 
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

//decoder 2 to 4
module decoder (a,b,en,y0,y1,y2,y3);
	input a, b, en;
	output y0,y1,y2,y3;
	assign y0= (~a) & (~b) & en;
	assign y1= (~a) & b & en;
	assign y2= a & (~ b) & en;
	assign y3= a & b & en;
endmodule



//JK Flip Flop
module jk(q,q1,j,k,c);
	output q,q1;
	input j,k,c;
	reg q,q1;
	initial begin q=1'b0; q1=1'b1; end
	always @ (posedge c)
	begin
		case({j,k})
			{1'b0,1'b0}:begin q=q; q1=q1; end
			{1'b0,1'b1}: begin q=1'b0; q1=1'b1; end
			{1'b1,1'b0}:begin q=1'b1; q1=1'b0; end
			{1'b1,1'b1}: begin q=~q; q1=~q1; end
		endcase
   end
endmodule




// MUX 4 to 1
module mux( stb, d, q,enable );
	input stb;
	input[1:0] select;
	input[3:0] d;
	output     q;
	
	wire      q;
	wire[1:0] select;
	wire[3:0] d;

	assign q = d[select];
endmodule




//RAM 4 to 1
module ram(
	input [1:0]a,
	input wr,
	input Din,
	input Rd,
	input Dout
);
	wire d1,d2,d3,d4;
	wire d1_n,d2_n,d3_n,d4_n,Din_n;
	decoder d1 (.a(a[0]), .b(a[1]), .en(wr), .y0(d1), .y1(d2), .y2(d3), .y3(d4));
	
	not G1(d1_n,d1);
	not G2(d2_n,d2);
	not G3(d3_n,d3);
	not G4(d4_n,d4);
	not G5(Din_n,Din);
	
	wire [3:0] j;

	jk jk1(.q(j[0]), .q1(), .j(Din), .k(Din_n), .c(d1_n));
	jk jk2(.q(j[1]), .q1(), .j(Din), .k(Din_n), .c(d2_n));
	jk jk3(.q(j[2]), .q1(), .j(Din), .k(Din_n), .c(d3_n));
	jk jk4(.q(j[3]), .q1(), .j(Din), .k(Din_n), .c(d4_n));
	
	mux m1(.stb(), .select(a), .d(j1), .q(Dout));

endmodule
