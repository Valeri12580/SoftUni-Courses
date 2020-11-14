import {data} from './data';
import {Article} from '../models/article.model';


export class Mapper {

   getData():Article[] {
    let database: Article[] = [];

    for (let i = 0; i < data.length; i++) {
      let dataObj: {
        title,
        description,
        author,
        imageUrl
      } = data[i];
      database.push(new Article(dataObj.title,dataObj.description,dataObj.author,dataObj.imageUrl));


    }
     return database;
  }
}
