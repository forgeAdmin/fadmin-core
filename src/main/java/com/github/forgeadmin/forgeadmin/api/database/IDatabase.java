package com.github.forgeadmin.forgeadmin.api.database;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;

import java.io.IOException;
import java.util.HashMap;

public interface IDatabase {

  String databaseId();

  /**
   * Called at the end of PreInit. Init connections here?
   * @param event
   */
  void initDatabase(FMLPreInitializationEvent event);

  /**
   * Called at the end of server shutdown. End connections here?
   */
  void closeDatabase(FMLServerStoppedEvent event);

  <T> T fromDatabase(String collection, String key, Class<T> classOfT) throws IOException;

  <T> HashMap<String, T> fromDatabase(String collection, Class<T> classOfT) throws IOException;

  void toDatabase(String collection, String key, Object object) throws IOException;
}
