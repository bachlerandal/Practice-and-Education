row(1..8).
column(1..8).

%queens and row/column positions
8 {queen(X, Y) : row(X), column(Y)} 8.

%:- not n { queen(X, Y) } n.


%No horizontal attacks
:- queen(X, Y1), queen(X, Y2), Y1 != Y2.

%No up/down attacks
:- queen(X1, Y), queen(X2, Y), X1 != X2.

%No diagonal attacks
:- queen(X, Y), queen(XX, YY), (X, Y) != (XX, YY), X+Y == XX+YY.
:- queen(X, Y), queen(XX, YY), (X, Y) != (XX, YY), X-Y == XX-YY.

#show queen/2.
