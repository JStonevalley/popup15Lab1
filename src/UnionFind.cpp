//
//  main.cpp
//  popup15Lab1C++
//
//  Created by Erik Ranby and Jonas Stendahl on 03/09/15.
//

#include <iostream>
#include <cstring>
#include "UnionFind.h"

using namespace std;

int main(int argc, const char * argv[]) {
    
    int numElements;
    int numOperations;
    cin >> numElements;
    cin >> numOperations;
    
    Element elements[numElements];
    for (int i = 0; i < numElements; i++) {
        Element el;
        el.parent = i;
        el.rank = 0;
        elements[i] = el;
    }
//    cout << "elements[3].parent: " << elements[3].parent << endl;
//    cout << "elements[3].rank: " << elements[3].rank << endl;
    
    char operation[1];
    int num1;
    int num2;
    for (int i = 0; i < numOperations; i++) {
        cin >> operation;
        cin >> num1;
        cin >> num2;
        if (strcmp(operation, "?") == 0) {
            int root1 = findRoot(elements, num1);
            int root2 = findRoot(elements, num2);
            if (root1 == root2) {
                cout << "yes" << endl;
            }
            else {
                cout << "no" << endl;
            }
        }
        else if (strcmp(operation, "=") == 0) {
            unite(elements, num1, num2);
        }
    }
    return 0;
}

int findRoot(struct Element elements[], int elementId)
{
    int parent = elements[elementId].parent;
    if (parent == elementId) {
        return elementId;
    } else {
        elements[elementId].parent = findRoot(elements, parent);
        return elements[elementId].parent;
    }
}

void unite(struct Element elements[], int elementId1, int elementId2)
{
    int root1 = findRoot(elements, elementId1);
    int root2 = findRoot(elements, elementId2);
    if (root1 == root2) {
        return;
    }
    
    if (elements[root1].rank > elements[root2].rank) {
        elements[root2].parent = root1;
    }
    else if (elements[root1].rank < elements[root2].rank) {
        elements[root1].parent = root2;
    }
    else {
        elements[root1].parent = root2;
        elements[root2].rank = elements[root2].rank + 1;
    }
//    elements[root1].parent = root2;
}


