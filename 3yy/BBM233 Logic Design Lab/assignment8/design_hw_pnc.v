`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    18:15:47 01/19/2018 
// Design Name: 
// Module Name:    primeCounter 
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

module jkffs(J,K,clock,Q,Qbar);

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



module primeCounter(
	input x,
	output [3:0]ot,
	input clk
	);
	
	wire q0,q1,q2,q3;
	
	jkffs f1(.J(1), .K(q1*q2), .clock(clk), .Q(ot[0]), .Qbar(q0));
	jkffs f2(.J(q3), .K(ot[0]*q2), .clock(clk), .Q(ot[1]), .Qbar(q1));
	jkffs f3(.J(ot[0]*ot[1]), .K(ot[1]+ot[3]), .clock(clk), .Q(ot[2]), .Qbar(q2));
	jkffs f4(.J(ot[2]*ot[1]), .K(q1), .clock(clk), .Q(ot[3]), .Qbar(q3));



endmodule
