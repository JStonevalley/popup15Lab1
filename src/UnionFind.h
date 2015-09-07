//
//  UnionFind.h
//  popup15Lab1C++
//
//  Created by Erik Ranby on 03/09/15.
//  Copyright (c) 2015 Erik Ranby. All rights reserved.
//

#ifndef popup15Lab1C___UnionFind_h
#define popup15Lab1C___UnionFind_h

struct Element {
    int parent;
    int rank;
};

int findRoot(struct Element elements[], int elementId);

void unite(struct Element elements[], int elementId1, int elementId2);

void checkAndCreateElement(struct Element elements[], int elementId);


#endif
