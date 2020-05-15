package utils;

public class RandomTime {
    private long timeFactor;

    public RandomTime(long timeFactor) {
        this.timeFactor = timeFactor;
    }

    public long getRandomTime() {
        return (long) (Math.random() * timeFactor + timeFactor);
    }
}
