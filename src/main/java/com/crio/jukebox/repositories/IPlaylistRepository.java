import com.crio.jukebox.entities.PlayList;

public interface IPlaylistRepository extends CRUDRepository<Playlist, String>  
{
    public String getPlayingPlaylistId();
    public void setPlayingPlaylistId(String playingPlayListId);
    
}
