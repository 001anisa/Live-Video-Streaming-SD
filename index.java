import java.nio.file.FileSystem;

public class VideoConsumingService 
{
    private Database database;
public int seekTime(String userId,String VideoId)
{
    WatchedVideo wv = database.getWatchedVideo(userId,VideoId);
    return wv.getSeekTime();
}

}


class Video
{
    
    String id;
    Frame[] frames;
    String jsonMetaData;

    public Frame getFrame(int ts)
    {
        for(int i=0; i<frames.length; i++)
        {
            if(frames[i].startTimestamp<= ts && frames[i].endTimestamp+Frame.FrameTime >= ts)
                {
                    return frames[i];
                }        
        }
        throw new IndexOutOfBoundsException(ts);
    }
}

class Frame{
    byte[] bytes;
    int timestamp;
    public static int FrameTime=10;
    int startTimestamp;
    int endTimestamp;
}

class User
{
    String id;
    String username;
    String Email;

    public String getId()
    {
        return id;
    }

}

class WatchVideo{
    String id;
    String VideoId;
    String UserId;
    int seekTime;

    public int getSeekTime()
    {
        return seekTime;
    }
}

class Database
{
    public WatchVideo getWatchVideo(String userID,String VideoId)
    {
        return null;
    }
}

class VideoService
{
    private FileSystem fs;
    public Frame getFrame(String VideoId,int ts)
    {
        Video video = fs.getVideo(VideoId);
        return video.getFrame(ts);
    }
}