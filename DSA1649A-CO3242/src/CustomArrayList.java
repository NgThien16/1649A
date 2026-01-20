public class CustomArrayList<E> {
    private Object[] array;
    private int size;

    public CustomArrayList(){
        array = new Object[10];
        size = 0;
    }
    public void resize(){
        if(size == array.length){
            Object[] temp = new Object[array.length*2];
            for(int i=0;i<size;i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }
    public boolean add(E element){
        if(size == array.length){
            resize();
        }
        array[size] = element;
        size ++;
        return true;
    }

}
