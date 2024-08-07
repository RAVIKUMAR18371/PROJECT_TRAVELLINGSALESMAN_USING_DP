1.  ABSTRACT:
   TRAVELLING SALESMAN  problem , is a permutation problem in which
    I am  giving a complete undirected graph where the graph contains
    the number of cities in which there is given a number of edges in
     the graph through which the person can travel to the  different
     cities and finally come back to its starting city from where he
     has started and there is given their respective edge-weight or
     edge-cost, finally my objective is to find the minimum cost
     HAMILTONIAN CYCLE.

2.  CONTENT:
    The TRAVELLING SALESMAN problem is a very famous problem in  real Life,
     The TRAVELLING SALESMAN  problem (TSP) is a classic optimization problem
      in computer science and mathematics. It is a combinatorial problem that
      seeks to determine the shortest possible route that a salesman can take
      to visit a given set of cities and return to the starting city, visiting
      each city exactly once.

    In more technical terms, the problem can be stated as follows:
     Given a list of cities and the distances between each pair of cities,
     the goal is to find the shortest possible route that visits each city
     exactly once and returns to the starting city.

    The TSP is known to be an NP-hard problem, which means that there is
     no known efficient algorithm to solve it for large instances in a
     reasonable amount of time. As the number of cities increases, the
      number of possible routes grows exponentially, making it impractical
       to check all possible route.

3. INTRODUCTION:
    a) overview::
      The TRAVELLING SALES PERSON problem is an algorithm based problem in
       which our prior objective is to find the  shortest route between the
        set of points in the graph or between the set of cities, if we talk
        about the real life scenario. In the problem statement, the points are
         the set of cities where the sales person might visit.

    b) problem Description::
       TRAVELLING SALES PROBLEM(TSP) using dynamic programming involves finding
        the shortest distance between the cities, if the person start from one-city,
         which is the STARTING-CITY and travel to the other city , where he want to
          go by using the  mode of transportation, And  by using the minimum distance
           path which is available in the starting city to reach to the other city.
            The distance from starting city to the other city should be minimum among
             all possible way which are available in that city to reach to the other city.
             At last he will come back to its STARTING-CITY.

4. PROBLEM STATEMENT:
      Suppose we have given a total 4 number of cities- Delhi, Mumbai, Kolkata, Bengaluru,
       such that there is a distance available among all the set of cities.

      Distance(Delhi-Mumbai) = 20

      Distance(Mumbai-Kolkata) = 30

      Distance(Kolkata-Bengaluru) =10

      Distance(Bengaluru-Delhi) = 25

      Distance(Delhi-Kolkata) = 42

      Distance(Bangalore-Mumbai) = 34

      And the Distance(city1-city1) = 0 and now the person has to travel through
       all the cities with the shortest route among the set of cities and finally
        come back to STARTING-CITY, then find the minimum distance in the Hamiltonian
         cycle.

 5. ASSUMPTIONS:
    -->To formulate the TSP using dynamic programming, we make the following assumptions:
    1. The problem exhibits optimal substructure: An optimal solution to the problem
     contains optimal solutions to its sub-problems. In other words, we can break down
      the problem into smaller sub-problems and solve them independently.

    2. The problem satisfies the overlapping sub-problems property: The number of distinct
     sub-problems is small compared to the total number of sub-problems that need to be solved.
      This allows us to store the solutions to sub-problems and reuse them to avoid redundant
       computation.

 6. MATHEMATICAL-FORMULATION::
    GIVEN:
    Suppose there are set of 4 cities and the DISTANCE MATRIX-distance[pos][city] ,
    which represent the distance between the STARTING CITY to the CURRENT CITY.

    Pos: STARTING CITY POSITION.
    City: CURRENT CITY POSITION.

    VARIABLE:
    Let us define the binary variable V[city1][city2] that takes the value 1, if
    the person travels from city 1 to city 2,Otherwise V[city1][city2] takes the
    value 0 , if  city1=city2  or there is no way between the set of city.

    Let us define the Tsp(int mask, int pos) function which contains,

    Mask: The set of cities which has visited so far, so from mask we come to know
     that which cities has not been visited.
     Pos:  The position of the current city or from which city I am going to the next
            city.
    The goal is to find the minimum cost Hamiltonian cycle , i.e. a cycle that starts
     and ends at city1 and visit each city exactly once, with the smallest possible cost.

    By using DYNAMIC PROGRAMMING ,
    Tsp(mask, pos) = min{(distance[pos][city] + Tsp(mask | (1 << city)) , (city) }

    Value of:
    Mask != pos

    City belongs to: set of cities.

 7. DESIGNING ALGORITHM::
  --> PSEUDOCODE:
     1st line---->TRAVELLING_SALESMAN{

     2nd line----> N<--length(distances);

     3rd line-----> DP<--2d array of size (2powN)*N , initialized with infinite value.

     4th line---->

     5th line---->

     6th line ----> Initially when no cities are visited

     7th line-----> DP[i][j] <-- -1

     8th line-----> when all cities are visited

     9th line-----> VISITED_ALL = (1 << n) -1

     10th line--->

     11th line----> TSP(Mask, Pos){

     12th line--->
     13th line---->If(mask == VISITED_ALL)​

      14th line---> {

      15th line---->return distance[pos][0];

      16th line----->}

      17th line----->If(Dp[mask][pos] != -1){

      18th line------>return Dp[mask][pos];

      19th line------> }

      20th line------->Let Variable,

      21th line------->Ans <----- MAX_VALUE of integer

     22nd line------>

      23rd line------>For(city<-- 0; city< N; city++)

      24th line----->{

      25th line------>if ((mask & (1 << city)) == 0) {
      26th line------>int  newAns  <--- distance[pos][city] + Tsp(mask | (1 << city), city);

      27th line------>Ans <---- Math. min(Ans ,  newAns);}
      28th line-------> }  return Dp[mask][pos] = Ans;
      29th line------->  }

 8. EXAMPLES::

    The Traveling Salesman Problem (TSP) has real-life applications in various
     industries and scenarios. Here are a few examples of how the TSP can be
     applied in practical situations:

    a). Delivery Routes: Delivery companies often need to determine the most
    efficient routes for their drivers to deliver packages to multiple destinations.
     By solving the TSP, the company can optimize the order in which deliveries are
      made, minimizing the distance traveled and reducing fuel consumption.

    b). Network Routing: The TSP has applications in network routing protocols,
    where data needs to be transmitted through a network of nodes. By finding
    the shortest path or sequence of nodes to visit, the TSP helps optimize network
     traffic and reduce delays.

 9. IMPLEMENTATION::
    ---> refer to the code section.

 10. RESULT AND DISCUSSION::
     * The Traveling Salesman Problem (TSP) is a well-known mathematical problem
      that involves finding the shortest possible route that a salesman can take
       to visit a set of cities and return to the starting point. Solving the TSP
        has practical implications in various domains, such as logistics,
        transportation, and network routing. Here, we will discuss the potential
        results and implications of the Traveling Salesman Problem:

    1. Optimal Route Determination: The primary result of solving the TSP is
     determining the optimal route that minimizes the total distance traveled.
     This can help optimize logistics operations, reduce transportation costs,
     and improve efficiency. By finding the shortest route, travel time and fuel
     consumption can be minimized, leading to cost savings and improved resource
      utilization.

   2. Improved Planning and Scheduling: Solving the TSP allows for better planning
    and scheduling of travel routes. It enables salespersons or delivery drivers to
     efficiently visit multiple cities or destinations in the most optimal sequence,
      considering distance and time constraints. This can lead to improved productivity,
       reduced travel time, and better customer service.

     Resource Optimization: The TSP can help optimize the allocation and utilization
     of resources. By determining the most efficient route, it enables businesses
      to allocate vehicles, drivers, and other resources effectively. This can minimize
       idle time, reduce operational costs, and enhance overall resource management.

      Real-World Constraints: In practice, the TSP needs to consider real-world constraints
       such as one-way streets, traffic conditions, time windows, and other factors that
        impact the feasibility of certain routes. Incorporating these constraints into the
         TSP solution adds complexity but leads to more realistic and practical results.

 11. Limitation::

    The Traveling Salesman Problem (TSP) is a well-known mathematical problem that
     involves finding the shortest  possible route that a salesman can take to visit
     a set of cities and return to the starting point. While there are algorithms and
     techniques to solve the TSP, it is still a complex problem with certain limitations.
      Here are some limitations of the Traveling Salesman Problem:

     Computational Complexity: The TSP is classified as an NP-hard problem, meaning that
      it becomes exponentially more difficult to solve as the number of cities increases.
       The time required to find the optimal solution grows rapidly, making it impractical
       to solve large-scale instances of the problem in a reasonable amount of time.

     Lack of Consideration for Other Factors: The TSP primarily focuses on finding the
     shortest route in terms of distance. However, in practical scenarios, there may be
      other factors to consider, such as time constraints, traffic conditions, road
      closures, or specific customer requirements. These additional factors make the
       problem more complex and may require incorporating them into the solution.

 12. Future Enhancement::
     Integration of Real-World Constraints: Enhancing the TSP by incorporating real-world
      constraints and factors such as road networks, traffic patterns, vehicle capacities,
       and time constraints is essential. These enhancements can lead to more realistic
        and practical TSP solutions that align with real-world scenarios,
        These future enhancements of the TSP aim to overcome its limitations, improve
         solution quality, and make it more applicable to real-world scenarios. By
         continually advancing algorithms,  incorporating real-world constraints, and
          exploring problem variations, researchers can continue to push the boundaries
           of TSP optimization and find efficient solutions for a wide range of applications.

 13. Reference::
     Dantzig, G. B., Fulkerson, R. L., & Johnson, S. M. (1954).
     Solution of a Large-Scale Traveling-Salesman Problem.
     Operations Research, 2(4), 393-410.

     Applegate, D. L., Bixby, R. E., Chvátal, V., & Cook, W. J. (2006).
      The Traveling Salesman Problem: A Computational Study. Princeton University Press.

      Cook, W. J. (2012). In Pursuit of the Traveling Salesman:
      Mathematics at the Limits of Computation. Princeton University Press.

     These references provide a comprehensive overview of the Traveling Salesman Problem,
      its variations, algorithms, computational complexity, and practical applications.
       They serve as valuable resources for further understanding and research on the TSP
        and it also helps in understanding the Traveling Salesman Problem (TSP) that you
         can explore for more in-depth information:



     -------------*THANK YOU*----------
