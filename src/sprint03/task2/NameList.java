package sprint03.task2;

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {

        private int counter;

        private Iterator() {
            counter = 0;
        }

        public boolean hasNext() {
            return counter < names.length;
        }

        public String next() {
            if (hasNext()) {
                return names[counter++];
            } else throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) {
        NameList n = new NameList();
        NameList.Iterator iterator = new NameList().getIterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }

}