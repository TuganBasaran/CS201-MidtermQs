package Array;

public class Stack {
    private Element[] array;
    private int top;
    private int N;

    public Stack(int N){
        this.N = N;
        array = new Element[N];
        top = -1;
    }

    boolean isFull(){
        return top == N - 1;
    }

    boolean isEmpty(){
        return top == -1;
    }

    Element peek(){
        return array[top];
    }

    void push(Element element){
        if (!isFull()){
            top++;
            array[top] = element;
        }
    }

    Element pop(){
        if (!isEmpty()){
            top--;
            return array[top + 1];
        }
        return null;
    }

    /** Write a function using stacks that determines if a parenthesis sequence
    is balanced or not. For example the parenthesis sequence ( ( ) ( ) ) is
    balanced, whereas the parenthesis sequence ( ( ( ) ( is not. You can
    assume that the character sequence contains just ’(’ and ’)’ characters. */
    boolean isBalanced(String s){
        Stack stack = new Stack(s.length());
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(new Element(s.charAt(i)));
            } else if (s.charAt(i) == ')'){
                if (stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    /**  Write a function using stacks that determines if a parenthesis sequence
    is balanced or not. For example the parenthesis sequence ( { ()[ { }
    ] } ( ) ) is balanced, whereas the parenthesis sequence ( } ] ) ( is not.
    You can assume that the character sequence contains just (, {, [, ), }, ] characters. */

    boolean isBalanced2(String s){
        Stack theSameStack = new Stack(s.length()); 
        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i)=='{' || s.charAt(i)== '['){
                theSameStack.push(new Element(s.charAt(i)));
            } else if(s.charAt(i)== ']' || s.charAt(i)== '}' || s.charAt(i) == ')'){
                if(theSameStack.isEmpty()){
                    return false; 
                } else if (theSameStack.peek().getData() == '(' && s.charAt(i) == ')') {
                    theSameStack.pop(); 
                } else if (theSameStack.peek().getData() == '[' && s.charAt(i) == ']') {
                    theSameStack.pop(); 
                } else if (theSameStack.peek().getData() == '{' && s.charAt(i) == '}') {
                    theSameStack.pop(); 
                } else {
                    return false; 
                }
            }
        }
        return theSameStack.isEmpty(); 
    }

    /** For array representation, write a function that enlarges the stack when
it is full. The new stack will hold two times more than the original stack. */
    void enlarge (){
        Element[] newArray = new Element[N*2];
        for (int i = 0; i < N; i++){
            newArray[i] = array[i];
        }
        array = newArray;
        N = N*2;
    }

    /*  Write a method which pops the k’th element from the top and returns
    it. pop(1) is equal to the original pop, that is, the first element at the
    top has index 1. You are not allowed to use any stack methods and
    any external stacks, just attributes, constructors, getters and setters.
    Write the code for both array and linked list implementations. */
    Element pop (int k){
        Element element; 
        Element[] newElements = new Element[N-1];
        for(int i = 0; i < k; i++){
            newElements[i] = array[i]; 
        } 
        element = array[k];
        for(int i = k; i < N-1; i++){
            newElements[i] = array[i+1];
        } 
        array = newElements; 
        return element;
    }
}