import { NgModule } from '@angular/core';
import { Routes, RouterModule, Route } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { AddPostsComponent } from './add-posts/add-posts.component';
import { PostsComponent } from './posts/posts.component';

let routes: Route[] = [
  { path: '', component: HomeComponent },
  { path: 'header', component: HeaderComponent },
  { path: 'addposts', component: AddPostsComponent },
  { path: 'posts', component: PostsComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
