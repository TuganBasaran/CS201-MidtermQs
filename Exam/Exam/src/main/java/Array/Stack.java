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
