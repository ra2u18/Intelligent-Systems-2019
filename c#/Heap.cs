using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;

public class Heap<T> where T : IHeapItem<T>
{
    T[] items;
    int itemsCount;

    public Heap(int maxHeapSize)
    {
        items = new T[maxHeapSize];
    }

    public void Add(T item)
    {
        // Set the index of the item as being the last index of the array.
        item.HeapIndex = itemsCount;
        items[itemsCount] = item;
        SortUp(item);
        itemsCount++;
    }

    public T RemoveFirst()
    {
        T firstItem = items[0];
        itemsCount--;
        items[0] = items[itemsCount];
        items[0].HeapIndex = 0;

        SortDown(items[0]);
        return firstItem;
    }

    private void SortDown(T item)
    {
        while (true)
        {
            int childIndexLeft = item.HeapIndex * 2 + 1;
            int childIndexRight = item.HeapIndex * 2 + 2;
            int swapIndex = 0;

            if (childIndexLeft < itemsCount)
            {
                swapIndex = childIndexLeft;

                if (childIndexRight < itemsCount)
                {
                    if (items[childIndexRight].CompareTo(items[childIndexLeft]) > 0)
                    {
                        swapIndex = childIndexRight;
                    }
                }

                if (item.CompareTo(items[swapIndex]) < 0)
                {
                    Swap(item, items[swapIndex]);
                }
                else break;
            }
            else break;
        }
    }

    public void UpdateItem(T item)
    {
        // If we find a better path to a specific node, update f cost.
        SortUp(item);
    }

    public int Count
    {
        get
        {
            return itemsCount;
        }
    }

    public bool Contains(T item)
    {
        return Equals(items[item.HeapIndex], item);
    }

    private void SortUp(T item)
    {
        int parentIndex = (item.HeapIndex - 1) / 2;
        while (true)
        {
            T parentItem = items[parentIndex];

            // If current item has higher priority than the parent, swap.
            if(item.CompareTo(parentItem) > 0)
                Swap(item, parentItem);
            else
                return;

            parentIndex = (item.HeapIndex - 1) / 2;
        }
    }

    private void Swap(T itemA, T itemB)
    {
        items[itemA.HeapIndex] = itemB;
        items[itemB.HeapIndex] = itemA;

        int temp = itemA.HeapIndex;
        itemA.HeapIndex = itemB.HeapIndex;
        itemB.HeapIndex = temp;
    }

}

public interface IHeapItem<T> : IComparable<T>
{
    int HeapIndex
    {
        get;
        set;
    }
}
