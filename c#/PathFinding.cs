using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Diagnostics;

public class PathFinding : MonoBehaviour
{

    public Transform seeker;
    public Transform goal;

    // Reference to the grid.
    Grid grid;

    private void Awake()
    {
        grid = GetComponent<Grid>();
    }

    private void Update()
    {
        FindPath(seeker.position, goal.position);
    }

    void FindPath(Vector3 startPosition, Vector3 targetPosition)
    {
        Stopwatch sw = new Stopwatch();
        sw.Start();

        Node startNode = grid.getNodeFromWorldPoint(startPosition);
        Node targetNode = grid.getNodeFromWorldPoint(targetPosition);

        //List<Node> openSet = new List<Node>();
        Heap<Node> openSet = new Heap<Node>(grid.MaxHeapSize);
        HashSet<Node> closedSet = new HashSet<Node>();

        openSet.Add(startNode);

        while(openSet.Count > 0)
        {
            //Node currentNode = openSet[0];
            //// find node with lowest f-cost; costly part of the algorithm.
            //for(int x = 1; x < openSet.Count; x++)
            //{
            //    if(openSet[x].fCost < currentNode.fCost || openSet[x].fCost == currentNode.fCost)
            //    {
            //        if(openSet[x].hCost < currentNode.hCost)
            //        {
            //            currentNode = openSet[x];
            //        }
            //    }
            //}

            Node currentNode = openSet.RemoveFirst();

            closedSet.Add(currentNode);

            if(currentNode == targetNode)
            {
                sw.Stop();
                RetracePath(startNode, targetNode);
                print("Found path in: " + sw.ElapsedMilliseconds + " ms");
                return;
            }

            foreach(Node neighbor in grid.GetNeighbors(currentNode))
            {
                if(!neighbor.walkable || closedSet.Contains(neighbor))
                    continue;

                int newCostToNeighbour = currentNode.gCost + GetDistance(currentNode, neighbor);

                if(newCostToNeighbour < neighbor.gCost || !openSet.Contains(neighbor))
                {
                    neighbor.gCost = newCostToNeighbour;
                    neighbor.hCost = GetDistance(neighbor, targetNode);
                    neighbor.parent = currentNode;

                    if (!openSet.Contains(neighbor))
                    {
                        openSet.Add(neighbor);
                    }

                }

            }

        }

    }

    private int GetDistance(Node A, Node B)
    {
        int dstX = Mathf.Abs(A.gridX - B.gridX);
        int dstY = Mathf.Abs(A.gridY - B.gridY);

        return 14 * Mathf.Min(dstX, dstY) + 10 * Mathf.Abs(dstX - dstY);
    }

    private void RetracePath(Node startNode, Node targetNode)
    {
        List<Node> path = new List<Node>();
        Node currentNode = targetNode;

        while(currentNode != startNode)
        {
            path.Add(currentNode);
            currentNode = currentNode.parent;
        }

        path.Reverse();

        grid.path = path;
    }

}
