
# coding: utf-8
################################################################################
# A *nondeterministic finite automaton* defined as 5-tuple $(Q,F,q_{0},\Sigma,
# \delta)$ where:
#
# * $Q$ - is a finite set of *states*
# * $F \subseteq Q$ - is a set of *final states*
# * $q_{0} \in Q$ - is the *initial state*
# * $\Sigma$ - is the *input alphabet*
# * $\delta : Q \times \Sigma \cup \{\lambda\} \to 2^{Q}$ is a *transition
#   function*
#
# For our purposes, we will represent an NFA in Python as a tuple of the form
# `(Q,F,I,S,D)` where:
#
# * `Q` - is a set of strings representing the states of the NFA
# * `F` - is a set of strings representing the final states of the NFA
# * `I` - is a string representing the initial state of the NFA
# * `S` - is a set of characters (i.e. strings of length 1) representing the
#   input alphabet of the NFA
# * `D` - is a set of triples of the form `(X,Y,Z)` representing individual
#   transitions
#
# As an example, we define a simple NFA as follows:
#################################################################################
Q = {'1', '2', '3', '4', '5'}
F = {'5'}
I = '1'
S = {'a', 'b'}
D = {
    ('1', '', '2'),
    ('1', 'a', '3'),
    ('2', 'a', '5'),
    ('2', 'a', '4'),
    ('3', 'b', '4'),
    ('4', 'a', '5'),
    ('4', 'b', '5')
}

NFA = (Q,F,I,S,D)


# The set of states of the equivalent DFA is the powerset of the set of states
# of the NFA. Towards that end, we define the following function for computing
# the powerset of given set:

def powerlist(S):
    """
    Returns the powerset of the given set S as a list of lists.
    """
    result = [[]]
    for x in S:
        result.extend([subset + [x] for subset in result])
    return result

def powerset(S):
    """
    Returns the powerset of the given set S.
    """
    return frozenset(map(frozenset, powerlist(S)))


# Additionally, as part of the conversion it is necessary to define the
# $\lambda$-closure of state in the NFA. The $\lambda$-closure of a given state
# S is the set of states in the NFA that are reachable from S via zero or more
# $\lambda$ transitions (i.e. empty string transitions).

def lambda_closure(NFA, S):
    """
    Returns the lambda-closure of a state within the NFA (i.e. the set of states
    reachable from S by zero or more empty string transitions).
    """
    closure = {S}
    neighbors = {x[2] for x in NFA[4] if x[0] == S and x[1] == '' and x[1] != S}
    for neighbor in neighbors:
        closure = set.union(closure, lambda_closure(NFA,neighbor))
    return frozenset(closure)


# Now we need to obtain the transition function of the equivalent DFA. This is
# done via the following function:

def generate_dfa(NFA):
    # the initial state is defined as the lambda-closure of the initial
    # state of the given NFA
    Q0 = lambda_closure(NFA, NFA[2])

    # the alphabet is identical to that of the given NFA
    Sigma = NFA[3]
    D = []
    todo = [Q0]
    seen = []
    Q = []
    while len(todo) != 0:
        State = todo.pop(0)
        Q.append(State)
        seen.append(State)
        for ch in Sigma:
            state = set()
            for src in State:
                dests = {x[2] for x in NFA[4] if x[0] == src and x[1] == ch}
                closures = set()
                for dest in dests:
                    closures = set.union(closures,lambda_closure(NFA,dest))
                state = set.union(state,closures)
            D.append((State,ch,frozenset(state)))
            if state not in seen:
                todo.append(frozenset(state))
    F = [S for S in Q if S & NFA[1] != frozenset()]
    return (set(Q),set(F),Q0,Sigma,set(D))
