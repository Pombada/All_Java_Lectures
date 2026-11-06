package Week3;

public class Lab3 {
    /**
     * Implement the observer pattern such that BrowserNewsApp and MobileNewsApp register to NewsDesk on creation
     * and NewsDesk updates the registered apps whenever a new push arrives
     */

    interface NewsObserver {
        void PushNewsFlash (String newsFlash);
    }
    interface NewsSubject{
        void registerObserver(NewsObserver observer);
        void unregisterObserver(NewsObserver observer);
        void notifyObservers(String newsFlash);

    }

    class NewsDesk implements NewsSubject {
        private NewsObserver[] observers = new NewsObservers[400];
        private int observersIndex = 0;
        private String news = "";
        public void registerObserver(NewsObserver observer){
            observers[observersIndex++] = observer;
        }
        public void unregisterObserver(NewsObserver observer){
            for(int i = 0; i < observersIndex; i++ ){
                if (NewsObserver[i] == observer){
                    i = null;
                    observersIndex--;
                    break;
                }

            }
        }
        public void notifyObservers(String newsFlash){
            for(NewsObserver i : observers){
                if(i!=null)
                    i.PushNewsFlash(newsFlash);
            }

        }

        public void printNews(){
            System.out.println("News Summary:");
            System.out.print(news);
        }

        public String getLastPush() {
            String[] lines = news.split("\n");
            return lines.length == 0
                    ? null
                    : lines[lines.length - 1];
        }
    }

    class BrowserNewsApp implements NewsObserver {
        private NewsDesk desk;
        public BrowserNewsApp(NewsDesk desk) {
            this.desk = desk;
            desk.registerObserver(this);
        }



        private void PushNewsFlash (String newsFlash) {
            System.out.println("Browser News App News Flash: "+newsFlash);
        }
    }

    class MobileNewsApp  implements NewsObserver {
        private NewsDesk desk;
        public MobileNewsApp(NewsDesk desk) {
            this.desk = desk;
            desk.registerObserver(this);
        }



        private void PushNewsFlash (String newsFlash) {
            System.out.println("Mobile News App News Flash: "+newsFlash);
        }
    }
}
