# bus-route-challenge

This is the solution that I have come up with, for the bus route challenge. The solution takes into consideration the space and time complexities
in order to ensure that we respond to the requests at the earliest possible while still having the ability to fit into suitable machines without memory problems.

## The solution

The proposed solution attempts to keep track of the station IDs by indexing their routes. This ensures that we save as much memory as possible while still
storing the indexed routes in a hash map, ensuring that search for the station connections are still fast. The file is read into memory and stored in a map of station IDs 
and their Set of routes.  
