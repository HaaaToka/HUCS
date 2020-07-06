`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    21:29:38 12/09/2017 
// Design Name: 
// Module Name:    e4s1 
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

module jkflipflop(J,K,clock,Q,Qbar);

	input J,K,clock;
	output Q,Qbar;
	
	reg Q,Qbar;
	initial begin Q=1'b0; Qbar=1'b1; end
	always @(posedge clock)
		begin
				case({J,K})
					 {1'b0,1'b0}:begin Q=Q; Qbar=Qbar; end
					 {1'b0,1'b1}: begin Q=1'b0; Qbar=1'b1; end
					 {1'b1,1'b0}:begin Q=1'b1; Qbar=1'b0; end
					 {1'b1,1'b1}: begin Q=~Q; Qbar=~Qbar; end
				endcase
   end
	
	
endmodule

module e4s1(J,clock,Out);

	output [0:3]Out;
	input J,clock;
	
	wire Jnot;
	not G1(Jnot,J);
	
	jkflipflop jkff0(.J(J), .K(Jnot), .clock(clock), .Q(Out[0]), .Qbar(Out[1]));
	jkflipflop jkff1(.J(Out[0]), .K(Out[1]), .clock(clock), .Q(Out[2]), .Qbar(Out[3]));

endmodule
		
