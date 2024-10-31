class Solution {
    public int countSeniors(String[] details) {

        int age = 0;
        int count = 0;

        for (String st : details) {
            String str = st.substring(11, 13);
            age = Integer.parseInt(str);
            if (age > 60) {
                count++;
            }
        }

        return count;

    }
}