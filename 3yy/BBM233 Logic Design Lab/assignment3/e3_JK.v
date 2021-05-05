`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:25:49 11/19/2017 
// Design Name: 
// Module Name:    mymodule 
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
module mymodule(J,K,Clk,R,S,CE,Qout);

	 input J,K;  //inputs
    input Clk;  //clock
    input R;    //reset
    input S; //set
    input CE; //clock enabled
    output Qout;  //output
	 
    reg Qout;
    
    always@ (posedge(Clk))
	 
    begin
        if(R == 1) 
            Qout = 0;
        else    
            if(S == 1) 
                Qout = 1;
            else
                if(CE == 1) //J,K values are considered only when CE is ON.
                    if(J == 0 && K == 0)    
                        Qout = Qout; //no change
                    else if(J == 0 && K == 1)
                        Qout = 0;  //reset
                    else if(J == 1 && K == 0)
                        Qout = 1;  //set
                    else
                        Qout = ~Qout;
                else
                    Qout = Qout; //no change
    end

endmodule
