package org.jboss.jdf.example.ticketmonster.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Event implements Serializable
{

   @Id
   private @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   Long id = null;
   @Version
   private @Column(name = "version")
   int version = 0;

   @NotNull
   @Column
   private @Size(message = "Must be > 5 and < 50", min = 5, max = 50)
   String name;

   @Column
   private @Size(message = "Must be > 20 and < 1000", min = 20, max = 1000)
   String description;

   @Column
   private boolean major;

   @Column
   private String picture;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((Event) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public String getDescription()
   {
      return this.description;
   }

   public void setDescription(final String description)
   {
      this.description = description;
   }

   public boolean getMajor()
   {
      return this.major;
   }

   public void setMajor(final boolean major)
   {
      this.major = major;
   }

   public String getPicture()
   {
      return this.picture;
   }

   public void setPicture(final String picture)
   {
      this.picture = picture;
   }

   public String toString()
   {
      String result = "";
      if (name != null && !name.trim().isEmpty())
         result += name;
      if (description != null && !description.trim().isEmpty())
         result += " " + description;
      result += " " + major;
      if (picture != null && !picture.trim().isEmpty())
         result += " " + picture;
      return result;
   }
}