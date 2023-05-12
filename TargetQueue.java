package assignment2;

public class TargetQueue extends MyQueue<Position>{

    private MyStack<String> positions;
    private MyStack brackets;

    public TargetQueue(){
        super();
        positions = new MyStack<String>();
        brackets = new MyStack();
    }

    public void clear(){
        super.clear();
    }

    public void addTargets(String input){

        String num = "";
        boolean wasLeft = false;
        boolean wasRight = false;
        boolean wasDot = false;
        boolean dotCount = false;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '('){
                if(!num.isEmpty() || !positions.isEmpty()){
                    throw new IllegalArgumentException("( num or stack not empty");
                }
                positions.push("(");
                brackets.push("(");
                dotCount = false;

            } else if(Character.isDigit(input.charAt(i))) {
                //if the character is a digit, append the digit to num.
                num = num + input.charAt(i);

            } else if(input.charAt(i) == ',') {
                //if the character is a comma, check if num is a valid integer.
                // If num is empty, we must have read a comma before the x-coordinate, which is a syntax error.
                // Otherwise, push num and "," onto the stack, in exactly this order. Finally, reset num.
                try{
                    int n = Integer.parseInt(num);
                } catch (Exception NumberFormatException) {
                    throw new IllegalArgumentException("Syntax error or no int in nums.");
                }

                wasLeft = true;
                if(wasRight && !wasDot){
                    throw new IllegalArgumentException("no period between");
                }
                wasRight = false;
                wasDot = false;

                positions.push(num);
                positions.push(",");
                num = "";

            } else if(input.charAt(i) == ')'){
                if(positions.getSize() != 3){
                    throw new IllegalArgumentException("stack too long");
                }
                if(num.isEmpty()){
                    throw new IllegalArgumentException("num is empty");
                }
                if(brackets.isEmpty()){
                    throw new IllegalArgumentException("No matching bracket");
                }

                positions.pop(); //(
                String xS = positions.pop();
                positions.pop(); //,
                brackets.pop();

                wasRight = true;
                int x = Integer.parseInt(xS);
                int y = Integer.parseInt(num);
                num = "";

                Position pos = new Position(x,y);
                enqueue(pos);

            } else if(input.charAt(i) == '.') {
                if (!positions.isEmpty() || !num.isEmpty() || !brackets.isEmpty()) {
                    throw new IllegalArgumentException("end but pos or num not empty");
                }
                if(dotCount){
                    throw new IllegalArgumentException("There was just a .");
                }
                dotCount = true;
                wasDot = true;
            } else if(input.charAt(i) == ' ') {
                throw new IllegalArgumentException("disallowed character");
            } else{
                throw new IllegalArgumentException("disallowed character");
            }
        }

        if(!brackets.isEmpty()){
            throw new IllegalArgumentException("over and brackets isn't empty");
        }

    }




}
