package service;

import entity.ManageTeaching;
import entity.Subject;

public interface BaseService<Entity> {
     void setTempListData(Entity[] tempList);
     int getTrueListLength(Entity[] tempList);
     void mergeNewListAndSetId ( Entity[] newList ,Entity[] tempList);
     void mergeNewData(Entity newEntity, Entity[] tempList);
}
