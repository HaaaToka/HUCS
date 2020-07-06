`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    19:48:11 25/12/2018 
// Design Name: 
// Module Name:    counter 
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
module counter(clk,rst,mode,counter);
	input clk,rst,mode;
	output [4:0] counter;
	
	reg [4:0] state,next;
	
	localparam	S0=5'b00001,
					S1=5'b01000,
					S2=5'b00011,
					S3=5'b10101,
					S4=5'b10000;
					
	always @(state,mode)
		case (state)
			S0: if (mode) next=S4;
				 else	 next=S1;
				
			S1: if (mode) next=S0;
				 else	 next=S2;
				
			S2: if (mode) next=S1;
				 else	 next=S3;
				
			S3: if (mode) next=S2;
				else	 next=S4;
				
			S4: if (mode) next=S3;
				else	 next=S0;
			
			default: next = 5'bxxxxx;
		endcase

	
	always @(negedge rst ,posedge clk)
		if(!rst) state<=S0;
		else  state<=next;
	
	assign counter=state;
	
endmodule 

/**********************************************************

testbench icin

module tb_dn;

	// Inputs
	reg clk;
	reg rst;
	reg mode;

	// Outputs
	wire [4:0] counter;

	// Instantiate the Unit Under Test (UUT)
	counter uut (
		.clk(clk), 
		.rst(rst), 
		.mode(mode),  
		.counter(counter)
	);

	initial begin
		clk = 0;
		rst = 0;
		mode = 0;
		#100;
		rst=1;
	end
	always #10 clk=~clk;
	always #500 mode=~mode;
      
      
endmodule


**************************************************************/