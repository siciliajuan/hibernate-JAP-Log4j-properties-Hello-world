package es.juansicilia.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class SimpleObject implements Serializable
{
   private static final long serialVersionUID = -2862671438138322400L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private int id;

   @Version
   @Column(name = "version")
   private int version = 0;

   public int getId()
   {
      return this.id;
   }

   public void setId(int i)
   {
      this.id = i;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }
}
