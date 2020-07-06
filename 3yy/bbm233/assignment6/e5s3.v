`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    15:08:32 12/17/2017 
// Design Name: 
// Module Name:    e5s3 
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


module e5s3(clck,out);
	
	input clck;
	output out;
	
	wire A,B,C,N;
	
	jkflipflop f0(.J(C), .K(), .clock(clck), .Q(A), .Qbar());
	jkflipflop f1(.J(A), .K(A), .clock(clck), .Q(B), .Qbar());
	and(N,A,B);
	jkflipflop f2(.J(N), .K(out), .clock(clck), .Q(out), .Qbar(C));
	
	/*jkflipflop f0(.J(out[4]), .K(), .clock(clck), .Q(out[0]), .Qbar());
	jkflipflop f1(.J(out[0]), .K(out[0]), .clock(clck), .Q(out[1]), .Qbar());
	and G1(out[2],out[0],out[1]);
	jkflipflop f2(.J(out[2]), .K(out[3]), .clock(clck), .Q(out[3]), .Qbar(out[4]));*/

endmodule
