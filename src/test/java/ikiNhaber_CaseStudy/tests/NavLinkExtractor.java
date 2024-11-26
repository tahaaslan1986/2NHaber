package ikiNhaber_CaseStudy.tests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NavLinkExtractor {

    public static Set<String> navLinks = new HashSet<>();

    public static void main(String[] args) {
        String htmlContent = """
                    <section class="elementor-section elementor-top-section elementor-element elementor-element-75eba054 elementor-reverse-tablet elementor-reverse-mobile elementor-section-boxed elementor-section-height-default elementor-section-height-default cmsmasters-block-default" data-id="75eba054" data-element_type="section" data-settings="{&quot;background_background&quot;:&quot;classic&quot;}">
                    						<div class="elementor-container elementor-column-gap-no">
                    					<div class="elementor-column elementor-col-25 elementor-top-column elementor-element elementor-element-374746a6" data-id="374746a6" data-element_type="column">
                    			<div class="elementor-widget-wrap elementor-element-populated">
                    						<section class="elementor-section elementor-inner-section elementor-element elementor-element-4f84af59 elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default cmsmasters-block-default" data-id="4f84af59" data-element_type="section">
                    						<div class="elementor-container elementor-column-gap-no">
                    					<div class="elementor-column elementor-col-100 elementor-inner-column elementor-element elementor-element-bb81135" data-id="bb81135" data-element_type="column">
                    			<div class="elementor-widget-wrap elementor-element-populated">
                    						<div class="elementor-element elementor-element-c2e84ea elementor-widget-widescreen__width-initial elementor-widget__width-initial cmsmasters-block-default cmsmasters-sticky-default elementor-widget elementor-widget-image" data-id="c2e84ea" data-element_type="widget" data-widget_type="image.default">
                    				<div class="elementor-widget-container">
                    													<img width="1812" height="1434" src="https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1.png" class="attachment-full size-full wp-image-33386 cmsmasters_img cmsmasters-lazyload lazyloaded" alt="" data-sizes="(max-width: 1812px) 100vw, 1812px" data-src="https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1.png" data-srcset="https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1.png 1812w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-300x237.png 300w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-1024x810.png 1024w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-768x608.png 768w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-1536x1216.png 1536w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-379x300.png 379w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-30x24.png 30w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-13x10.png 13w" sizes="(max-width: 1812px) 100vw, 1812px" srcset="https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1.png 1812w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-300x237.png 300w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-1024x810.png 1024w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-768x608.png 768w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-1536x1216.png 1536w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-379x300.png 379w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-30x24.png 30w, https://2nhaber.com/wp-content/uploads/2024/10/2n-logo-beyaz-512-1-13x10.png 13w">													</div>
                    				</div>
                    					</div>
                    		</div>
                    					</div>
                    		</section>
                    					</div>
                    		</div>
                    				<div class="elementor-column elementor-col-25 elementor-top-column elementor-element elementor-element-6a0526f4" data-id="6a0526f4" data-element_type="column">
                    			<div class="elementor-widget-wrap elementor-element-populated">
                    						<div class="elementor-element elementor-element-8752bdc elementor-widget__width-initial cmsmasters-dropdown-breakpoints-tablet cmsmasters-toggle-view-stacked cmsmasters-pointer-none cmsmasters-block-default cmsmasters-sticky-default elementor-widget elementor-widget-cmsmasters-nav-menu" data-id="8752bdc" data-element_type="widget" data-settings="{&quot;layout&quot;:&quot;vertical&quot;,&quot;vertical_menu_type&quot;:&quot;accordion&quot;,&quot;dropdown_breakpoints&quot;:&quot;tablet&quot;}" data-widget_type="cmsmasters-nav-menu.default">
                    				<div class="elementor-widget-container">
                    			<nav class="elementor-widget-cmsmasters-nav-menu__main elementor-widget-cmsmasters-nav-menu__container cmsmasters-layout-vertical cmsmasters-vertical-type-accordion cmsmasters-nav-menu-open-link"><ul id="menu-1-8752bdc" class="elementor-widget-cmsmasters-nav-menu__container-inner"><li id="menu-item-35115" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-35115"><a href="https://2nhaber.com/hakkimizda-2/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item elementor-widget-cmsmasters-nav-menu__item-link-top" aria-label="Menu item">Hakkımızda</a></li>
                    <li id="menu-item-34138" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-34138"><a href="https://2nhaber.com/kunye/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item elementor-widget-cmsmasters-nav-menu__item-link-top" aria-label="Menu item">Künye</a></li>
                    <li id="menu-item-34137" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-34137"><a href="https://2nhaber.com/iletisim/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item elementor-widget-cmsmasters-nav-menu__item-link-top" aria-label="Menu item">İletişim</a></li>
                    </ul></nav><div class="elementor-widget-cmsmasters-nav-menu__toggle-container cmsmasters-layout-vertical cmsmasters-menu-dropdown-type-"><div class="elementor-widget-cmsmasters-nav-menu__toggle cmsmasters-icon-align-"><span class="cmsmasters-toggle-icon"><svg class="e-font-icon-svg e-fas-bars" viewBox="0 0 448 512" xmlns="http://www.w3.org/2000/svg"><path d="M16 132h416c8.837 0 16-7.163 16-16V76c0-8.837-7.163-16-16-16H16C7.163 60 0 67.163 0 76v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16z"></path></svg></span><span class="cmsmasters-toggle-icon-active"><svg class="e-font-icon-svg e-fas-times" viewBox="0 0 352 512" xmlns="http://www.w3.org/2000/svg"><path d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"></path></svg></span></div></div><nav class="elementor-widget-cmsmasters-nav-menu__dropdown elementor-widget-cmsmasters-nav-menu__container cmsmasters-layout-vertical cmsmasters-menu-dropdown-type- cmsmasters-arrow-animation- cmsmasters-vertical-type-accordion"><ul id="cmsmasters_menu-4-8752bdc" class="elementor-widget-cmsmasters-nav-menu__container-inner cmsmasters-nav-menu-dropdown ps"><li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-35115"><a href="https://2nhaber.com/hakkimizda-2/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item" aria-label="Menu item">Hakkımızda</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-34138"><a href="https://2nhaber.com/kunye/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item" aria-label="Menu item">Künye</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-34137"><a href="https://2nhaber.com/iletisim/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item" aria-label="Menu item">İletişim</a></li>
                    <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></ul></nav>		</div>
                    				</div>
                    					</div>
                    		</div>
                    				<div class="elementor-column elementor-col-25 elementor-top-column elementor-element elementor-element-292d4d32" data-id="292d4d32" data-element_type="column">
                    			<div class="elementor-widget-wrap elementor-element-populated">
                    						<div class="elementor-element elementor-element-1d73422 elementor-widget__width-initial cmsmasters-dropdown-breakpoints-tablet cmsmasters-toggle-view-stacked cmsmasters-pointer-none cmsmasters-block-default cmsmasters-sticky-default elementor-widget elementor-widget-cmsmasters-nav-menu" data-id="1d73422" data-element_type="widget" data-settings="{&quot;layout&quot;:&quot;vertical&quot;,&quot;vertical_menu_type&quot;:&quot;accordion&quot;,&quot;dropdown_breakpoints&quot;:&quot;tablet&quot;}" data-widget_type="cmsmasters-nav-menu.default">
                    				<div class="elementor-widget-container">
                    			<nav class="elementor-widget-cmsmasters-nav-menu__main elementor-widget-cmsmasters-nav-menu__container cmsmasters-layout-vertical cmsmasters-vertical-type-accordion cmsmasters-nav-menu-open-link"><ul id="menu-1-1d73422" class="elementor-widget-cmsmasters-nav-menu__container-inner"><li id="menu-item-35129" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-35129"><a href="https://2nhaber.com/gizlilik-ilkeleri/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item elementor-widget-cmsmasters-nav-menu__item-link-top" aria-label="Menu item">Gizlilik İlkeleri</a></li>
                    <li id="menu-item-35130" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-35130"><a href="https://2nhaber.com/cerez-politikasi/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item elementor-widget-cmsmasters-nav-menu__item-link-top" aria-label="Menu item">Çerez Politikası</a></li>
                    <li id="menu-item-35131" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-35131"><a href="https://2nhaber.com/hakkimizda/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item elementor-widget-cmsmasters-nav-menu__item-link-top" aria-label="Menu item">Aydınlatma Metni</a></li>
                    </ul></nav><div class="elementor-widget-cmsmasters-nav-menu__toggle-container cmsmasters-layout-vertical cmsmasters-menu-dropdown-type-"><div class="elementor-widget-cmsmasters-nav-menu__toggle cmsmasters-icon-align-"><span class="cmsmasters-toggle-icon"><svg class="e-font-icon-svg e-fas-bars" viewBox="0 0 448 512" xmlns="http://www.w3.org/2000/svg"><path d="M16 132h416c8.837 0 16-7.163 16-16V76c0-8.837-7.163-16-16-16H16C7.163 60 0 67.163 0 76v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16z"></path></svg></span><span class="cmsmasters-toggle-icon-active"><svg class="e-font-icon-svg e-fas-times" viewBox="0 0 352 512" xmlns="http://www.w3.org/2000/svg"><path d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"></path></svg></span></div></div><nav class="elementor-widget-cmsmasters-nav-menu__dropdown elementor-widget-cmsmasters-nav-menu__container cmsmasters-layout-vertical cmsmasters-menu-dropdown-type- cmsmasters-arrow-animation- cmsmasters-vertical-type-accordion"><ul id="cmsmasters_menu-4-1d73422" class="elementor-widget-cmsmasters-nav-menu__container-inner cmsmasters-nav-menu-dropdown ps"><li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-35129"><a href="https://2nhaber.com/gizlilik-ilkeleri/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item" aria-label="Menu item">Gizlilik İlkeleri</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-35130"><a href="https://2nhaber.com/cerez-politikasi/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item" aria-label="Menu item">Çerez Politikası</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-35131"><a href="https://2nhaber.com/hakkimizda/" class="elementor-widget-cmsmasters-nav-menu__dropdown-item" aria-label="Menu item">Aydınlatma Metni</a></li>
                    <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></ul></nav>		</div>
                    				</div>
                    					</div>
                    		</div>
                    				<div class="elementor-column elementor-col-25 elementor-top-column elementor-element elementor-element-67960464" data-id="67960464" data-element_type="column">
                    			<div class="elementor-widget-wrap elementor-element-populated">
                    						<div class="elementor-element elementor-element-00d7319 elementor-widget__width-initial cmsmasters-block-default cmsmasters-sticky-default elementor-widget elementor-widget-image" data-id="00d7319" data-element_type="widget" data-widget_type="image.default">
                    				<div class="elementor-widget-container">
                    													<img width="2302" height="572" src="https://2nhaber.com/wp-content/uploads/2024/10/Gif-YBK.gif" class="attachment-full size-full wp-image-33693" alt="">													</div>
                    				</div>
                    				<div class="elementor-element elementor-element-4c06b6b0 elementor-shape-circle e-grid-align-left elementor-grid-0 cmsmasters-block-default cmsmasters-sticky-default elementor-widget elementor-widget-social-icons" data-id="4c06b6b0" data-element_type="widget" data-widget_type="social-icons.default">
                    				<div class="elementor-widget-container">
                    					<div class="elementor-social-icons-wrapper elementor-grid">
                    							<span class="elementor-grid-item">
                    					<a class="elementor-icon elementor-social-icon elementor-social-icon-instagram elementor-repeater-item-b27f2c1" href="https://www.instagram.com/2n_news/" target="_blank">
                    						<span class="elementor-screen-only">Instagram</span>
                    						<svg class="e-font-icon-svg e-fab-instagram" viewBox="0 0 448 512" xmlns="http://www.w3.org/2000/svg"><path d="M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z"></path></svg>					</a>
                    				</span>
                    							<span class="elementor-grid-item">
                    					<a class="elementor-icon elementor-social-icon elementor-social-icon-facebook-f elementor-repeater-item-dbd60d9" href="https://www.facebook.com/2nnews" target="_blank">
                    						<span class="elementor-screen-only">Facebook-f</span>
                    						<svg class="e-font-icon-svg e-fab-facebook-f" viewBox="0 0 320 512" xmlns="http://www.w3.org/2000/svg"><path d="M279.14 288l14.22-92.66h-88.91v-60.13c0-25.35 12.42-50.06 52.24-50.06h40.42V6.26S260.43 0 225.36 0c-73.22 0-121.08 44.38-121.08 124.72v70.62H22.89V288h81.39v224h100.17V288z"></path></svg>					</a>
                    				</span>
                    							<span class="elementor-grid-item">
                    					<a class="elementor-icon elementor-social-icon elementor-social-icon-x-twitter elementor-repeater-item-ec7473d" href="https://x.com/2n_news" target="_blank">
                    						<span class="elementor-screen-only">X-twitter</span>
                    						<svg class="e-font-icon-svg e-fab-x-twitter" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><path d="M389.2 48h70.6L305.6 224.2 487 464H345L233.7 318.6 106.5 464H35.8L200.7 275.5 26.8 48H172.4L272.9 180.9 389.2 48zM364.4 421.8h39.1L151.1 88h-42L364.4 421.8z"></path></svg>					</a>
                    				</span>
                    							<span class="elementor-grid-item">
                    					<a class="elementor-icon elementor-social-icon elementor-social-icon-youtube elementor-repeater-item-6d3666b" href="https://www.youtube.com/@2n_news" target="_blank">
                    						<span class="elementor-screen-only">Youtube</span>
                    						<svg class="e-font-icon-svg e-fab-youtube" viewBox="0 0 576 512" xmlns="http://www.w3.org/2000/svg"><path d="M549.655 124.083c-6.281-23.65-24.787-42.276-48.284-48.597C458.781 64 288 64 288 64S117.22 64 74.629 75.486c-23.497 6.322-42.003 24.947-48.284 48.597-11.412 42.867-11.412 132.305-11.412 132.305s0 89.438 11.412 132.305c6.281 23.65 24.787 41.5 48.284 47.821C117.22 448 288 448 288 448s170.78 0 213.371-11.486c23.497-6.321 42.003-24.171 48.284-47.821 11.412-42.867 11.412-132.305 11.412-132.305s0-89.438-11.412-132.305zm-317.51 213.508V175.185l142.739 81.205-142.739 81.201z"></path></svg>					</a>
                    				</span>
                    							<span class="elementor-grid-item">
                    					<a class="elementor-icon elementor-social-icon elementor-social-icon-tiktok elementor-repeater-item-48d60ba" href="https://www.tiktok.com/@2n_news" target="_blank">
                    						<span class="elementor-screen-only">Tiktok</span>
                    						<svg class="e-font-icon-svg e-fab-tiktok" viewBox="0 0 448 512" xmlns="http://www.w3.org/2000/svg"><path d="M448,209.91a210.06,210.06,0,0,1-122.77-39.25V349.38A162.55,162.55,0,1,1,185,188.31V278.2a74.62,74.62,0,1,0,52.23,71.18V0l88,0a121.18,121.18,0,0,0,1.86,22.17h0A122.18,122.18,0,0,0,381,102.39a121.43,121.43,0,0,0,67,20.14Z"></path></svg>					</a>
                    				</span>
                    							<span class="elementor-grid-item">
                    					<a class="elementor-icon elementor-social-icon elementor-social-icon-linkedin-in elementor-repeater-item-a75fa2e" href="https://www.linkedin.com/company/2nn-news/" target="_blank">
                    						<span class="elementor-screen-only">Linkedin-in</span>
                    						<svg class="e-font-icon-svg e-fab-linkedin-in" viewBox="0 0 448 512" xmlns="http://www.w3.org/2000/svg"><path d="M100.28 448H7.4V148.9h92.88zM53.79 108.1C24.09 108.1 0 83.5 0 53.8a53.79 53.79 0 0 1 107.58 0c0 29.7-24.1 54.3-53.79 54.3zM447.9 448h-92.68V302.4c0-34.7-.7-79.2-48.29-79.2-48.29 0-55.69 37.7-55.69 76.7V448h-92.78V148.9h89.08v40.8h1.3c12.4-23.5 42.69-48.3 87.88-48.3 94 0 111.28 61.9 111.28 142.3V448z"></path></svg>					</a>
                    				</span>
                    					</div>
                    				</div>
                    				</div>
                    					</div>
                    		</div>
                    					</div>
                    		</section>
                """;

        // HTML içeriğini JSoup ile parse ediyoruz
        Document doc = Jsoup.parse(htmlContent);

        // <nav> elemanlarını seçiyoruz
        Elements navElements = doc.select("nav");

        // Tüm <a> etiketlerini listeye ekliyoruz
        Set<String> navLinks = new HashSet<>();
        for (Element nav : navElements) {
            for (Element link : nav.select("a")) {
                String href = link.attr("href");
                String text = link.text();

                // Aynı href'li ve aynı metni içeren bir link varsa, eklemiyoruz
                navLinks.add("Link: " + text + " (" + href + ")");
            }
        }

// Sonuçları liste olarak yazdırmak isterseniz
        for (String link : navLinks) {
            System.out.println(link);
        }
    }
}
