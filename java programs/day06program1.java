// In a distant galaxy, an ancient civilization built a hierarchical communication 
// network of interconnected relay stations. The structure of this network can be 
// reconstructed using two ancient data logs:
//     - Beacon Activation Order (analogous to in-order traversal)
//     - Final Signal Sent Order (analogous to post-order traversal)
    
// Using these logs, we can reconstruct the original relay network and process q
// ueries about signals reaching specific hierarchical levels.

// Given the Beacon Activation Order and the Final Signal Sent Order of a galactic 
// communication network, reconstruct the relay network. After reconstructing 
// the hierarchy, and the output should list the relay stations in the order they 
// appear in a level-wise transmission sequence.

// Input Format:
// -------------
// - An integer N representing the number of relay stations in the network.
// - A space-separated list of N integers representing the Beacon Activation Order 
//     (similar to in-order traversal).
// - A space-separated list of N integers representing the Final Signal Sent Order 
//     (similar to post-order traversal).

// Output Format:
// --------------
// A list of integers, level-wise transmission sequence.


// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7  




// Sample Output:
// ---------------
// [1, 2, 3, 4, 5, 6, 7]


// Explanation:  
// The logs correspond to the following hierarchical relay network:
//         1
//        / \  
//       2   3
//      / \  / \
//     4   5 6  7
// The level order is : 1 2 3 4 5 6 7 






public class day06program1 {
    
}
