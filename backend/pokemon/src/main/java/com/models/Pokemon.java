
 @Entity

public class Pokemon {
    @Id
    @GeneratedValue

    private Long id;
    private  String name;
    private String imageUrl;
    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pokemon other = (Pokemon) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        } else if (!imageUrl.equals(other.imageUrl))
            return false;
        return true;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public Pokemon(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Pokemon(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }
    
}
