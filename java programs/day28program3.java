// The government has set up a network of smart traffic lights connected 
// by roads, forming a tree structure with n traffic lights. Each road has a 
// communication delay measured in meters.

// Each road connects exactly two traffic lights, and all lights are connected 
// (i.e., there are no cycles).

// To maintain secure and efficient signal relays, the system allows only indirect
// communication — where two traffic lights can communicate via a third traffic 
// light (called the mediator) if:

// The total signal path length (distance from light A to mediator to light B) is 
// divisible by a given signal propagation speed.

// You are to compute, for each traffic light, the number of such valid (A → B) 
// communication pairs that it can mediate.

// Input Format:
// -------------
// Line-1: An integer N     // number of traffic lights
// Line-2: N-1 space sepearted integers,  light_from[].
// Line-3: N-1 space sepearted integers,  light_to[].
// Line-4: N-1 space sepearted integers,  road_lengths[].
// Line-5: An integer, signal_speed    // signal propagation speed

// Output Format:
// ---------------
// An array of size n, where the ith value is the number of valid pairs 
// that use traffic light i+1 as a mediator


// Sample Input:
// -------------
// 4
// 1 2 2
// 1 3 5
// 2 4 3
// 5

// Sample Output:
// --------------
// 2 0 2 2

public class day28program3 {

    
}