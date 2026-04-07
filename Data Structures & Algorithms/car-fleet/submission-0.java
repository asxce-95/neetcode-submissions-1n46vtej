class Car implements Comparable{
    int pos;
    int speed;
    double hop;;

    public Car(int p, int s, int t){
        this.pos = p;
        this.speed = s;

        this.hop = ((t-p)*1.0)/s;
    }

    public int compareTo(Object c){
        Car other = (Car)c;
        if(this.pos == other.pos){
            if(this.speed > other.speed){
                return -1;
            } else {
                return 1;
            }
        }

        return this.pos - other.pos;
    }

    public String toString(){
        return "[ " + pos + ", " + speed + ", " + hop + " ]";
    }

}

class Solution {
    public int carFleet(int t, int[] p, int[] s) {

        ArrayList<Car> cars = new ArrayList<>();

        for(int i=0; i<p.length ; i++){
            cars.add(new Car(p[i], s[i], t));
        }
        
        Collections.sort(cars);

        //System.out.println(cars);

        Stack<Double> stack = new Stack<>();

         for(int i=0; i<p.length ;){
            Car c = cars.get(i);
            if(stack.isEmpty()){
                stack.push(c.hop);
                i++;
                continue;
            }

            if( c.hop < stack.peek() ){
                stack.push(c.hop);
                i++;
            } else {
                stack.pop();
            }

        }

        //System.out.println(stack);
        return stack.size();
    }
}