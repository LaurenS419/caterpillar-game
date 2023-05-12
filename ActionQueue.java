package assignment2;

public class ActionQueue extends MyQueue<Direction>{

    private MyStack nums;
    private MyStack brackets;
    private MyStack letters;
    private MyQueue<Direction> queue;

    public ActionQueue(){
        nums = new MyStack();
        brackets = new MyStack();
        letters = new MyStack();
        queue = new MyQueue<Direction>();

    }

    public void clear(){
        super.clear();
    }

    public void loadFromEncodedString(String input){

        int num = 0;
        String letter = "";
        String lString = "";
        boolean done = false;

        for(int i = 0; i < input.length(); i++){
            if(Character.isDigit(input.charAt(i))){
                done = false;
                if(i+1 < input.length()){
                    if(Character.isDigit(input.charAt(i+1))){
                        String numberPair = String.valueOf(input.charAt(i));
                        numberPair = numberPair + String.valueOf(input.charAt(i+1));
                        nums.push(Integer.parseInt(numberPair));
                        done = true;
                        i = i + 1;
                    }
                }

                if(!done){
                    nums.push(Character.getNumericValue(input.charAt(i)));
                }

            } else if(input.charAt(i) == '['){
                if(nums.isEmpty()){
                    throw new IllegalArgumentException("nums empty");
                }
                if(!letters.isEmpty()){
                    throw new IllegalArgumentException("letters not empty");
                }
                brackets.push('[');

            } else if(input.charAt(i) == ']'){
                if(brackets.isEmpty() || letters.isEmpty()){
                    throw new IllegalArgumentException("brackets or letters empty");
                }
                brackets.pop();

                num = (int) nums.pop();
                letter = (String) letters.pop();

                for (int j = 0; j < num; j++) {
                    queueDir(letter);
                }

            } else if(input.charAt(i) == 'N' || input.charAt(i) == 'S' ||
                    input.charAt(i) == 'E' || input.charAt(i) == 'W'){

                if(brackets.isEmpty() && !nums.isEmpty()){
                    throw new IllegalArgumentException("number but no brackets");
                }

                done = false;
                if(i+1 < input.length()){
                    if(input.charAt(i+1) == 'N' || input.charAt(i+1) == 'S' ||
                            input.charAt(i+1) == 'E' || input.charAt(i+1) == 'W'){
                        String letterPair = Character.toString(input.charAt(i));
                        letterPair = letterPair + Character.toString(input.charAt(i+1));
                        letters.push(letterPair);
                        done = true;
                        i = i + 1;
                    }
                }

                if(!done) {
                    letters.push(Character.toString(input.charAt(i)));
                }

                if(brackets.isEmpty()){
                    letter = (String) letters.pop();
                    queueDir(letter);
                }
            }
            else {
                throw new IllegalArgumentException("disallowed char");
            }
        }
    }

    private void queueDir(String letter){
        if (letter.equals("N")) {
            enqueue(Direction.NORTH);
        } else if (letter.equals("S")) {
            enqueue(Direction.SOUTH);
        } else if (letter.equals("E")) {
            enqueue(Direction.EAST);
        } else if (letter.equals("W")) {
            enqueue(Direction.WEST);
        } //Norths
        else if (letter.equals("NS")) {
            enqueue(Direction.NORTH);
            enqueue(Direction.SOUTH);
        }else if (letter.equals("NE")) {
            enqueue(Direction.NORTH);
            enqueue(Direction.EAST);
        } else if (letter.equals("NW")) {
            enqueue(Direction.NORTH);
            enqueue(Direction.WEST);
        } else if (letter.equals("NN")) {
            enqueue(Direction.NORTH);
            enqueue(Direction.NORTH);
        } //Souths
        else if (letter.equals("SN")) {
            enqueue(Direction.SOUTH);
            enqueue(Direction.NORTH);
        }else if (letter.equals("SE")) {
            enqueue(Direction.SOUTH);
            enqueue(Direction.EAST);
        } else if (letter.equals("SW")) {
            enqueue(Direction.SOUTH);
            enqueue(Direction.WEST);
        } else if (letter.equals("SS")) {
            enqueue(Direction.SOUTH);
            enqueue(Direction.SOUTH);
        } //Easts
        else if (letter.equals("ES")) {
            enqueue(Direction.EAST);
            enqueue(Direction.SOUTH);
        }else if (letter.equals("EE")) {
            enqueue(Direction.EAST);
            enqueue(Direction.EAST);
        } else if (letter.equals("EW")) {
            enqueue(Direction.EAST);
            enqueue(Direction.WEST);
        } else if (letter.equals("EN")) {
            enqueue(Direction.EAST);
            enqueue(Direction.NORTH);
        } //Wests
        else if (letter.equals("WS")) {
            enqueue(Direction.WEST);
            enqueue(Direction.SOUTH);
        }else if (letter.equals("WE")) {
            enqueue(Direction.WEST);
            enqueue(Direction.EAST);
        } else if (letter.equals("WW")) {
            enqueue(Direction.WEST);
            enqueue(Direction.WEST);
        } else if (letter.equals("WN")) {
            enqueue(Direction.WEST);
            enqueue(Direction.NORTH);
        }

    }

    /*
                if(letter.length() == 1) {

                } else{
                    for(int m = 0; m < letter.length(); m++){

                        for(int j = 0; j < num; j++) {
                            if(letter.charAt(m) == 'N'){
                                enqueue(Direction.NORTH);
                                System.out.println("Add n");
                            } else if (letter.charAt(m) == 'S') {
                                enqueue(Direction.SOUTH);
                                System.out.println("add s");
                            } else if (letter.charAt(m) == 'E') {
                                enqueue(Direction.EAST);
                                System.out.println("add e");
                            } else if (letter.charAt(m) == 'W') {
                                enqueue(Direction.WEST);
                                System.out.println("add w");
                            }
                        }
                    }
                }
                */

}
