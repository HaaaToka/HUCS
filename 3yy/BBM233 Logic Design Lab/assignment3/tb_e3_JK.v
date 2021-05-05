`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   11:28:28 11/19/2017
// Design Name:   mymodule
// Module Name:   D:/exp3/test_mymodule.v
// Project Name:  exp3
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: mymodule
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module test_mymodule;

	// Inputs
	reg J;
	reg K;
	reg Clk;
	reg R;
	reg S;
	reg CE;

	// Outputs
	wire Qout;

	// Instantiate the Unit Under Test (UUT)
	mymodule uut (
		.J(J), 
		.K(K), 
		.Clk(Clk), 
		.R(R), 
		.S(S), 
		.CE(CE), 
		.Qout(Qout)
	);


    initial Clk = 0;
    always #10 Clk = ~Clk;
	 
	 
	 initial begin
        // Initialize Inputs
        J = 0;
        K = 0;
        R = 0;
        S = 0;
        CE = 0;
        #30;
        
        R = 1;  #50;
        R = 0;
        S = 1;  #50;
        S = 0;
        J = 1;  K = 1;  #50;
        CE = 1; #50;
        J = 0;  K = 0;  #50;
        J = 0;  K = 1;  #50;
        J = 1;  K = 0;  #50;
        J = 1;  K = 1;  #50;
        CE = 0;
    
	 

	end

	initial begin
		$monitor("J=%d, K=%d , Reset=%d , Set=%d , ClockEnable=%d",J,K,R,S,CE);
	end

      
endmodule

