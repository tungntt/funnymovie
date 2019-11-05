import { Injectable } from '@angular/core';
import { SERVER_API_URL } from 'app/app.constants';
import { MovieModel } from 'app/core/movie-render/movie.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SessionStorageService } from 'ngx-webstorage';
import { JhiLanguageService } from 'ng-jhipster';

@Injectable({
  providedIn: 'root'
})
export class MovieRenderService {
  constructor(private languageService: JhiLanguageService, private sessionStorage: SessionStorageService, private http: HttpClient) {}

  fetchAll(): Observable<MovieModel[]> {
    return this.http.get<MovieModel[]>(SERVER_API_URL + 'api/movie');
  }
}
