package jp.co.planaria.favoriteanime.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.planaria.favoriteanime.entity.Anime;

/**
 * アニメ画面を制御するコントローラー
 * @author tomariryuuta
 *
 */
@Controller
public class AnimeContoroller {
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Anime>animes = new ArrayList<Anime>();
		
		Anime tensura = new Anime(1,"転すら","スライム");
		Anime kimetsu = new Anime(2,"キメツの刃","鬼出る");
		
		animes.add(tensura);
		animes.add(kimetsu);
		
		//thymeleafに渡す
		model.addAttribute("animes", animes);
		
		return "list";
	}

	
}
