/* 
 * Copyright Vin Wong @ vinexs.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.vinexs.mdicon;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Typeface;

public class MaterialIcon {

	public static final int AUTO_THEME = -1;
	public static final int DARK_THEME = 0;
	public static final int LIGHT_THEME = 1;
	public static final int THEME_FREE = 255;
	
	protected static Typeface typeface = null;
	
	protected Context context = null;
	protected int theme = -1;
	protected int color = 0;
	protected int alpha = 255;
	
	public MaterialIcon( Context context ) {
		this.context = context;
	}
	
	public MaterialIcon setTheme(int theme) {
		this.theme = theme;
		return this;
	}
	
	public MaterialIcon setColor(int color) {
		this.color = color;
		return this;
	}
	
	public MaterialIcon setAlpah(int a) {
		this.alpha = a;
		return this;
	}
	
	public MaterialDrawable getMenuDrawable(String iconName) {
		String iconUnicode = "";
		try {
			iconUnicode = GoogleMaterialIcon.valueOf(iconName).getUnicode();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new MaterialDrawable(context, iconUnicode, theme, color, alpha).setMenuItemSize();
	}
	
	public MaterialDrawable getDrawable(String iconName) {
		String iconUnicode = "";
		try {
			iconUnicode = GoogleMaterialIcon.valueOf(iconName).getUnicode();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new MaterialDrawable(context, iconUnicode, theme, color, alpha);
	}
	
	/**
	 * Static access to get Material Design Icon.
	 */
	public static MaterialDrawable getDrawable( Context context, String iconName, int color ){
		String iconUnicode = "";
		try {
			iconUnicode = GoogleMaterialIcon.valueOf(iconName).getUnicode();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new MaterialDrawable(context, iconUnicode, color);
	}
	
	public static final Typeface getTypeface(Context context) throws Exception {
		if (typeface != null) {
			return typeface;
		}	
		File InternalFolder = new File(context.getFilesDir(), "typeface");
		if (!InternalFolder.exists()) {
			InternalFolder.mkdirs();
		}
		File fontFile = new File(InternalFolder, "google_material_design_icon.ttf");
		if (!fontFile.exists())
		{
			InputStream is = context.getResources().openRawResource(R.raw.google_material_design_icon);
			byte[] buffer = new byte[is.available()];
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fontFile));
			int l = 0;
			while ((l = is.read(buffer)) > 0) {
				bos.write(buffer, 0, l);
			}
			bos.close();					
		}
		typeface = Typeface.createFromFile( fontFile );
		return typeface;
	}
	
	public static enum GoogleMaterialIcon {
		
		ic_3d_rotation("\ue600"),
		ic_accessibility("\ue601"),
		ic_account_balance("\ue602"),
		ic_account_balance_wallet("\ue603"),
		ic_account_box("\ue604"),
		ic_account_child("\ue605"),
		ic_account_circle("\ue606"),
		ic_add_shopping_cart("\ue607"),
		ic_alarm("\ue608"),
		ic_alarm_add("\ue609"),
		ic_alarm_off("\ue60a"),
		ic_alarm_on("\ue60b"),
		ic_android("\ue60c"),
		ic_announcement("\ue60d"),
		ic_aspect_ratio("\ue60e"),
		ic_assessment("\ue60f"),
		ic_assignment("\ue610"),
		ic_assignment_ind("\ue611"),
		ic_assignment_late("\ue612"),
		ic_assignment_return("\ue613"),
		ic_assignment_returned("\ue614"),
		ic_assignment_turned_in("\ue615"),
		ic_autorenew("\ue616"),
		ic_backup("\ue617"),
		ic_book("\ue618"),
		ic_bookmark("\ue619"),
		ic_bookmark_outline("\ue61a"),
		ic_bug_report("\ue61b"),
		ic_cached("\ue61c"),
		ic_class("\ue61d"),
		ic_credit_card("\ue61e"),
		ic_dashboard("\ue61f"),
		ic_delete("\ue620"),
		ic_description("\ue621"),
		ic_dns("\ue622"),
		ic_done("\ue623"),
		ic_done_all("\ue624"),
		ic_event("\ue625"),
		ic_exit_to_app("\ue626"),
		ic_explore("\ue627"),
		ic_extension("\ue628"),
		ic_face_unlock("\ue629"),
		ic_favorite("\ue62a"),
		ic_favorite_outline("\ue62b"),
		ic_find_in_page("\ue62c"),
		ic_find_replace("\ue62d"),
		ic_flip_to_back("\ue62e"),
		ic_flip_to_front("\ue62f"),
		ic_get_app("\ue630"),
		ic_grade("\ue631"),
		ic_group_work("\ue632"),
		ic_help("\ue633"),
		ic_highlight_remove("\ue634"),
		ic_history("\ue635"),
		ic_home("\ue636"),
		ic_https("\ue637"),
		ic_info("\ue638"),
		ic_info_outline("\ue639"),
		ic_input("\ue63a"),
		ic_invert_colors("\ue63b"),
		ic_label("\ue63c"),
		ic_label_outline("\ue63d"),
		ic_language("\ue63e"),
		ic_launch("\ue63f"),
		ic_list("\ue640"),
		ic_lock("\ue641"),
		ic_lock_open("\ue642"),
		ic_lock_outline("\ue643"),
		ic_loyalty("\ue644"),
		ic_markunread_mailbox("\ue645"),
		ic_note_add("\ue646"),
		ic_open_in_browser("\ue647"),
		ic_open_in_new("\ue648"),
		ic_open_with("\ue649"),
		ic_pageview("\ue64a"),
		ic_payment("\ue64b"),
		ic_perm_camera_mic("\ue64c"),
		ic_perm_contact_cal("\ue64d"),
		ic_perm_data_setting("\ue64e"),
		ic_perm_device_info("\ue64f"),
		ic_perm_identity("\ue650"),
		ic_perm_media("\ue651"),
		ic_perm_phone_msg("\ue652"),
		ic_perm_scan_wifi("\ue653"),
		ic_polymer("\ue654"),
		ic_print("\ue655"),
		ic_query_builder("\ue656"),
		ic_question_answer("\ue657"),
		ic_receipt("\ue658"),
		ic_redeem("\ue659"),
		ic_report_problem("\ue65a"),
		ic_restore("\ue65b"),
		ic_room("\ue65c"),
		ic_schedule("\ue65d"),
		ic_search("\ue65e"),
		ic_settings("\ue65f"),
		ic_settings_applications("\ue660"),
		ic_settings_backup_restore("\ue661"),
		ic_settings_bluetooth("\ue662"),
		ic_settings_cell("\ue663"),
		ic_settings_display("\ue664"),
		ic_settings_ethernet("\ue665"),
		ic_settings_input_antenna("\ue666"),
		ic_settings_input_component("\ue667"),
		ic_settings_input_composite("\ue668"),
		ic_settings_input_hdmi("\ue669"),
		ic_settings_input_svideo("\ue66a"),
		ic_settings_overscan("\ue66b"),
		ic_settings_phone("\ue66c"),
		ic_settings_power("\ue66d"),
		ic_settings_remote("\ue66e"),
		ic_settings_voice("\ue66f"),
		ic_shop("\ue670"),
		ic_shop_two("\ue671"),
		ic_shopping_basket("\ue672"),
		ic_shopping_cart("\ue673"),
		ic_speaker_notes("\ue674"),
		ic_spellcheck("\ue675"),
		ic_star_rate("\ue676"),
		ic_stars("\ue677"),
		ic_store("\ue678"),
		ic_subject("\ue679"),
		ic_swap_horiz("\ue67a"),
		ic_swap_vert("\ue67b"),
		ic_swap_vert_circle("\ue67c"),
		ic_system_update_tv("\ue67d"),
		ic_tab("\ue67e"),
		ic_tab_unselected("\ue67f"),
		ic_theaters("\ue680"),
		ic_thumb_down("\ue681"),
		ic_thumb_up("\ue682"),
		ic_thumbs_up_down("\ue683"),
		ic_toc("\ue684"),
		ic_today("\ue685"),
		ic_track_changes("\ue686"),
		ic_translate("\ue687"),
		ic_trending_down("\ue688"),
		ic_trending_neutral("\ue689"),
		ic_trending_up("\ue68a"),
		ic_turned_in("\ue68b"),
		ic_turned_in_not("\ue68c"),
		ic_verified_user("\ue68d"),
		ic_view_agenda("\ue68e"),
		ic_view_array("\ue68f"),
		ic_view_carousel("\ue690"),
		ic_view_column("\ue691"),
		ic_view_day("\ue692"),
		ic_view_headline("\ue693"),
		ic_view_list("\ue694"),
		ic_view_module("\ue695"),
		ic_view_quilt("\ue696"),
		ic_view_stream("\ue697"),
		ic_view_week("\ue698"),
		ic_visibility("\ue699"),
		ic_visibility_off("\ue69a"),
		ic_wallet_giftcard("\ue69b"),
		ic_wallet_membership("\ue69c"),
		ic_wallet_travel("\ue69d"),
		ic_work("\ue69e"),
		ic_error("\ue69f"),
		ic_warning("\ue6a0"),
		ic_album("\ue6a1"),
		ic_av_timer("\ue6a2"),
		ic_closed_caption("\ue6a3"),
		ic_equalizer("\ue6a4"),
		ic_explicit("\ue6a5"),
		ic_fast_forward("\ue6a6"),
		ic_fast_rewind("\ue6a7"),
		ic_games("\ue6a8"),
		ic_hearing("\ue6a9"),
		ic_high_quality("\ue6aa"),
		ic_loop("\ue6ab"),
		ic_mic("\ue6ac"),
		ic_mic_none("\ue6ad"),
		ic_mic_off("\ue6ae"),
		ic_movie("\ue6af"),
		ic_my_library_add("\ue6b0"),
		ic_my_library_books("\ue6b1"),
		ic_my_library_music("\ue6b2"),
		ic_new_releases("\ue6b3"),
		ic_not_interested("\ue6b4"),
		ic_pause("\ue6b5"),
		ic_pause_circle_fill("\ue6b6"),
		ic_pause_circle_outline("\ue6b7"),
		ic_play_arrow("\ue6b8"),
		ic_play_circle_fill("\ue6b9"),
		ic_play_circle_outline("\ue6ba"),
		ic_play_shopping_bag("\ue6bb"),
		ic_playlist_add("\ue6bc"),
		ic_queue("\ue6bd"),
		ic_queue_music("\ue6be"),
		ic_radio("\ue6bf"),
		ic_recent_actors("\ue6c0"),
		ic_repeat("\ue6c1"),
		ic_repeat_one("\ue6c2"),
		ic_replay("\ue6c3"),
		ic_shuffle("\ue6c4"),
		ic_skip_next("\ue6c5"),
		ic_skip_previous("\ue6c6"),
		ic_snooze("\ue6c7"),
		ic_stop("\ue6c8"),
		ic_subtitles("\ue6c9"),
		ic_surround_sound("\ue6ca"),
		ic_video_collection("\ue6cb"),
		ic_videocam("\ue6cc"),
		ic_videocam_off("\ue6cd"),
		ic_volume_down("\ue6ce"),
		ic_volume_mute("\ue6cf"),
		ic_volume_off("\ue6d0"),
		ic_volume_up("\ue6d1"),
		ic_web("\ue6d2"),
		ic_business("\ue6d3"),
		ic_call("\ue6d4"),
		ic_call_end("\ue6d5"),
		ic_call_made("\ue6d6"),
		ic_call_merge("\ue6d7"),
		ic_call_missed("\ue6d8"),
		ic_call_received("\ue6d9"),
		ic_call_split("\ue6da"),
		ic_chat("\ue6db"),
		ic_clear_all("\ue6dc"),
		ic_comment("\ue6dd"),
		ic_contacts("\ue6de"),
		ic_dialer_sip("\ue6df"),
		ic_dialpad("\ue6e0"),
		ic_dnd_on("\ue6e1"),
		ic_email("\ue6e2"),
		ic_forum("\ue6e3"),
		ic_import_export("\ue6e4"),
		ic_invert_colors_off("\ue6e5"),
		ic_invert_colors_on("\ue6e6"),
		ic_live_help("\ue6e7"),
		ic_location_off("\ue6e8"),
		ic_location_on("\ue6e9"),
		ic_message("\ue6ea"),
		ic_messenger("\ue6eb"),
		ic_no_sim("\ue6ec"),
		ic_phone("\ue6ed"),
		ic_portable_wifi_off("\ue6ee"),
		ic_quick_contacts_dialer("\ue6ef"),
		ic_quick_contacts_mail("\ue6f0"),
		ic_ring_volume("\ue6f1"),
		ic_stay_current_landscape("\ue6f2"),
		ic_stay_current_portrait("\ue6f3"),
		ic_stay_primary_landscape("\ue6f4"),
		ic_stay_primary_portrait("\ue6f5"),
		ic_swap_calls("\ue6f6"),
		ic_textsms("\ue6f7"),
		ic_voicemail("\ue6f8"),
		ic_vpn_key("\ue6f9"),
		ic_add("\ue6fa"),
		ic_add_box("\ue6fb"),
		ic_add_circle("\ue6fc"),
		ic_add_circle_outline("\ue6fd"),
		ic_archive("\ue6fe"),
		ic_backspace("\ue6ff"),
		ic_block("\ue700"),
		ic_clear("\ue701"),
		ic_content_copy("\ue702"),
		ic_content_cut("\ue703"),
		ic_content_paste("\ue704"),
		ic_create("\ue705"),
		ic_drafts("\ue706"),
		ic_filter_list("\ue707"),
		ic_flag("\ue708"),
		ic_forward("\ue709"),
		ic_gesture("\ue70a"),
		ic_inbox("\ue70b"),
		ic_link("\ue70c"),
		ic_mail("\ue70d"),
		ic_markunread("\ue70e"),
		ic_redo("\ue70f"),
		ic_remove("\ue710"),
		ic_remove_circle("\ue711"),
		ic_remove_circle_outline("\ue712"),
		ic_reply("\ue713"),
		ic_reply_all("\ue714"),
		ic_report("\ue715"),
		ic_save("\ue716"),
		ic_select_all("\ue717"),
		ic_send("\ue718"),
		ic_sort("\ue719"),
		ic_text_format("\ue71a"),
		ic_undo("\ue71b"),
		ic_access_alarm("\ue71c"),
		ic_access_alarms("\ue71d"),
		ic_access_time("\ue71e"),
		ic_add_alarm("\ue71f"),
		ic_airplanemode_off("\ue720"),
		ic_airplanemode_on("\ue721"),
		ic_battery_20("\ue722"),
		ic_battery_30("\ue723"),
		ic_battery_50("\ue724"),
		ic_battery_60("\ue725"),
		ic_battery_80("\ue726"),
		ic_battery_90("\ue727"),
		ic_battery_alert("\ue728"),
		ic_battery_charging_20("\ue729"),
		ic_battery_charging_30("\ue72a"),
		ic_battery_charging_50("\ue72b"),
		ic_battery_charging_60("\ue72c"),
		ic_battery_charging_80("\ue72d"),
		ic_battery_charging_90("\ue72e"),
		ic_battery_charging_full("\ue72f"),
		ic_battery_full("\ue730"),
		ic_battery_std("\ue731"),
		ic_battery_unknown("\ue732"),
		ic_bluetooth("\ue733"),
		ic_bluetooth_connected("\ue734"),
		ic_bluetooth_disabled("\ue735"),
		ic_bluetooth_searching("\ue736"),
		ic_brightness_auto("\ue737"),
		ic_brightness_high("\ue738"),
		ic_brightness_low("\ue739"),
		ic_brightness_medium("\ue73a"),
		ic_data_usage("\ue73b"),
		ic_developer_mode("\ue73c"),
		ic_devices("\ue73d"),
		ic_dvr("\ue73e"),
		ic_gps_fixed("\ue73f"),
		ic_gps_not_fixed("\ue740"),
		ic_gps_off("\ue741"),
		ic_location_disabled("\ue742"),
		ic_location_searching("\ue743"),
		ic_multitrack_audio("\ue744"),
		ic_network_cell("\ue745"),
		ic_network_wifi("\ue746"),
		ic_nfc("\ue747"),
		ic_now_wallpaper("\ue748"),
		ic_now_widgets("\ue749"),
		ic_screen_lock_landscape("\ue74a"),
		ic_screen_lock_portrait("\ue74b"),
		ic_screen_lock_rotation("\ue74c"),
		ic_screen_rotation("\ue74d"),
		ic_sd_storage("\ue74e"),
		ic_settings_system_daydream("\ue74f"),
		ic_signal_cellular_0_bar("\ue750"),
		ic_signal_cellular_1_bar("\ue751"),
		ic_signal_cellular_2_bar("\ue752"),
		ic_signal_cellular_3_bar("\ue753"),
		ic_signal_cellular_4_bar("\ue754"),
		ic_signal_cellular_connected_no_internet_0_bar("\ue755"),
		ic_signal_cellular_connected_no_internet_1_bar("\ue756"),
		ic_signal_cellular_connected_no_internet_2_bar("\ue757"),
		ic_signal_cellular_connected_no_internet_3_bar("\ue758"),
		ic_signal_cellular_connected_no_internet_4_bar("\ue759"),
		ic_signal_cellular_no_sim("\ue75a"),
		ic_signal_cellular_null("\ue75b"),
		ic_signal_cellular_off("\ue75c"),
		ic_signal_wifi_0_bar("\ue75d"),
		ic_signal_wifi_1_bar("\ue75e"),
		ic_signal_wifi_2_bar("\ue75f"),
		ic_signal_wifi_3_bar("\ue760"),
		ic_signal_wifi_4_bar("\ue761"),
		ic_signal_wifi_off("\ue762"),
		ic_signal_wifi_statusbar_1_bar("\ue763"),
		ic_signal_wifi_statusbar_2_bar("\ue764"),
		ic_signal_wifi_statusbar_3_bar("\ue765"),
		ic_signal_wifi_statusbar_4_bar("\ue766"),
		ic_signal_wifi_statusbar_connected_no_internet_1("\ue767"),
		ic_signal_wifi_statusbar_connected_no_internet_2("\ue768"),
		ic_signal_wifi_statusbar_connected_no_internet_3("\ue769"),
		ic_signal_wifi_statusbar_connected_no_internet_4("\ue76a"),
		ic_signal_wifi_statusbar_connected_no_internet("\ue76b"),
		ic_signal_wifi_statusbar_not_connected("\ue76c"),
		ic_signal_wifi_statusbar_null("\ue76d"),
		ic_storage("\ue76e"),
		ic_usb("\ue76f"),
		ic_wifi_lock("\ue770"),
		ic_wifi_tethering("\ue771"),
		ic_attach_file("\ue772"),
		ic_attach_money("\ue773"),
		ic_border_all("\ue774"),
		ic_border_bottom("\ue775"),
		ic_border_clear("\ue776"),
		ic_border_color("\ue777"),
		ic_border_horizontal("\ue778"),
		ic_border_inner("\ue779"),
		ic_border_left("\ue77a"),
		ic_border_outer("\ue77b"),
		ic_border_right("\ue77c"),
		ic_border_style("\ue77d"),
		ic_border_top("\ue77e"),
		ic_border_vertical("\ue77f"),
		ic_format_align_center("\ue780"),
		ic_format_align_justify("\ue781"),
		ic_format_align_left("\ue782"),
		ic_format_align_right("\ue783"),
		ic_format_bold("\ue784"),
		ic_format_clear("\ue785"),
		ic_format_color_fill("\ue786"),
		ic_format_color_reset("\ue787"),
		ic_format_color_text("\ue788"),
		ic_format_indent_decrease("\ue789"),
		ic_format_indent_increase("\ue78a"),
		ic_format_italic("\ue78b"),
		ic_format_line_spacing("\ue78c"),
		ic_format_list_bulleted("\ue78d"),
		ic_format_list_numbered("\ue78e"),
		ic_format_paint("\ue78f"),
		ic_format_quote("\ue790"),
		ic_format_size("\ue791"),
		ic_format_strikethrough("\ue792"),
		ic_format_textdirection_l_to_r("\ue793"),
		ic_format_textdirection_r_to_l("\ue794"),
		ic_format_underline("\ue795"),
		ic_functions("\ue796"),
		ic_insert_chart("\ue797"),
		ic_insert_comment("\ue798"),
		ic_insert_drive_file("\ue799"),
		ic_insert_emoticon("\ue79a"),
		ic_insert_invitation("\ue79b"),
		ic_insert_link("\ue79c"),
		ic_insert_photo("\ue79d"),
		ic_merge_type("\ue79e"),
		ic_mode_comment("\ue79f"),
		ic_mode_edit("\ue7a0"),
		ic_publish("\ue7a1"),
		ic_vertical_align_bottom("\ue7a2"),
		ic_vertical_align_center("\ue7a3"),
		ic_vertical_align_top("\ue7a4"),
		ic_wrap_text("\ue7a5"),
		ic_attachment("\ue7a6"),
		ic_cloud("\ue7a7"),
		ic_cloud_circle("\ue7a8"),
		ic_cloud_done("\ue7a9"),
		ic_cloud_download("\ue7aa"),
		ic_cloud_off("\ue7ab"),
		ic_cloud_queue("\ue7ac"),
		ic_cloud_upload("\ue7ad"),
		ic_file_download("\ue7ae"),
		ic_file_upload("\ue7af"),
		ic_folder("\ue7b0"),
		ic_folder_open("\ue7b1"),
		ic_folder_shared("\ue7b2"),
		ic_cast("\ue7b3"),
		ic_cast_connected("\ue7b4"),
		ic_computer("\ue7b5"),
		ic_desktop_mac("\ue7b6"),
		ic_desktop_windows("\ue7b7"),
		ic_dock("\ue7b8"),
		ic_gamepad("\ue7b9"),
		ic_headset("\ue7ba"),
		ic_headset_mic("\ue7bb"),
		ic_keyboard("\ue7bc"),
		ic_keyboard_alt("\ue7bd"),
		ic_keyboard_arrow_down("\ue7be"),
		ic_keyboard_arrow_left("\ue7bf"),
		ic_keyboard_arrow_right("\ue7c0"),
		ic_keyboard_arrow_up("\ue7c1"),
		ic_keyboard_backspace("\ue7c2"),
		ic_keyboard_capslock("\ue7c3"),
		ic_keyboard_control("\ue7c4"),
		ic_keyboard_hide("\ue7c5"),
		ic_keyboard_return("\ue7c6"),
		ic_keyboard_tab("\ue7c7"),
		ic_keyboard_voice("\ue7c8"),
		ic_laptop("\ue7c9"),
		ic_laptop_chromebook("\ue7ca"),
		ic_laptop_mac("\ue7cb"),
		ic_laptop_windows("\ue7cc"),
		ic_memory("\ue7cd"),
		ic_mouse("\ue7ce"),
		ic_phone_android("\ue7cf"),
		ic_phone_iphone("\ue7d0"),
		ic_phonelink("\ue7d1"),
		ic_phonelink_off("\ue7d2"),
		ic_security("\ue7d3"),
		ic_sim_card("\ue7d4"),
		ic_smartphone("\ue7d5"),
		ic_speaker("\ue7d6"),
		ic_tablet("\ue7d7"),
		ic_tablet_android("\ue7d8"),
		ic_tablet_mac("\ue7d9"),
		ic_tv("\ue7da"),
		ic_watch("\ue7db"),
		ic_add_to_photos("\ue7dc"),
		ic_adjust("\ue7dd"),
		ic_assistant_photo("\ue7de"),
		ic_audiotrack("\ue7df"),
		ic_blur_circular("\ue7e0"),
		ic_blur_linear("\ue7e1"),
		ic_blur_off("\ue7e2"),
		ic_blur_on("\ue7e3"),
		ic_brightness_1("\ue7e4"),
		ic_brightness_2("\ue7e5"),
		ic_brightness_3("\ue7e6"),
		ic_brightness_4("\ue7e7"),
		ic_brightness_5("\ue7e8"),
		ic_brightness_6("\ue7e9"),
		ic_brightness_7("\ue7ea"),
		ic_brush("\ue7eb"),
		ic_camera("\ue7ec"),
		ic_camera_alt("\ue7ed"),
		ic_camera_front("\ue7ee"),
		ic_camera_rear("\ue7ef"),
		ic_camera_roll("\ue7f0"),
		ic_center_focus_strong("\ue7f1"),
		ic_center_focus_weak("\ue7f2"),
		ic_collections("\ue7f3"),
		ic_color_lens("\ue7f4"),
		ic_colorize("\ue7f5"),
		ic_compare("\ue7f6"),
		ic_control_point("\ue7f7"),
		ic_control_point_duplicate("\ue7f8"),
		ic_crop_3_2("\ue7f9"),
		ic_crop_5_4("\ue7fa"),
		ic_crop_7_5("\ue7fb"),
		ic_crop_16_9("\ue7fc"),
		ic_crop("\ue7fd"),
		ic_crop_din("\ue7fe"),
		ic_crop_free("\ue7ff"),
		ic_crop_landscape("\ue800"),
		ic_crop_original("\ue801"),
		ic_crop_portrait("\ue802"),
		ic_crop_square("\ue803"),
		ic_dehaze("\ue804"),
		ic_details("\ue805"),
		ic_edit("\ue806"),
		ic_exposure("\ue807"),
		ic_exposure_minus_1("\ue808"),
		ic_exposure_minus_2("\ue809"),
		ic_exposure_plus_1("\ue80a"),
		ic_exposure_plus_2("\ue80b"),
		ic_exposure_zero("\ue80c"),
		ic_filter_1("\ue80d"),
		ic_filter_2("\ue80e"),
		ic_filter_3("\ue80f"),
		ic_filter_4("\ue810"),
		ic_filter_5("\ue811"),
		ic_filter_6("\ue812"),
		ic_filter_7("\ue813"),
		ic_filter_8("\ue814"),
		ic_filter_9("\ue815"),
		ic_filter_9_plus("\ue816"),
		ic_filter("\ue817"),
		ic_filter_b_and_w("\ue818"),
		ic_filter_center_focus("\ue819"),
		ic_filter_drama("\ue81a"),
		ic_filter_frames("\ue81b"),
		ic_filter_hdr("\ue81c"),
		ic_filter_none("\ue81d"),
		ic_filter_tilt_shift("\ue81e"),
		ic_filter_vintage("\ue81f"),
		ic_flare("\ue820"),
		ic_flash_auto("\ue821"),
		ic_flash_off("\ue822"),
		ic_flash_on("\ue823"),
		ic_flip("\ue824"),
		ic_gradient("\ue825"),
		ic_grain("\ue826"),
		ic_grid_off("\ue827"),
		ic_grid_on("\ue828"),
		ic_hdr_off("\ue829"),
		ic_hdr_on("\ue82a"),
		ic_hdr_strong("\ue82b"),
		ic_hdr_weak("\ue82c"),
		ic_healing("\ue82d"),
		ic_image("\ue82e"),
		ic_image_aspect_ratio("\ue82f"),
		ic_iso("\ue830"),
		ic_landscape("\ue831"),
		ic_leak_add("\ue832"),
		ic_leak_remove("\ue833"),
		ic_lens("\ue834"),
		ic_looks_3("\ue835"),
		ic_looks_4("\ue836"),
		ic_looks_5("\ue837"),
		ic_looks_6("\ue838"),
		ic_looks("\ue839"),
		ic_looks_one("\ue83a"),
		ic_looks_two("\ue83b"),
		ic_loupe("\ue83c"),
		ic_movie_creation("\ue83d"),
		ic_nature("\ue83e"),
		ic_nature_people("\ue83f"),
		ic_navigate_before("\ue840"),
		ic_navigate_next("\ue841"),
		ic_palette("\ue842"),
		ic_panorama("\ue843"),
		ic_panorama_fisheye("\ue844"),
		ic_panorama_horizontal("\ue845"),
		ic_panorama_vertical("\ue846"),
		ic_panorama_wide_angle("\ue847"),
		ic_photo("\ue848"),
		ic_photo_album("\ue849"),
		ic_photo_camera("\ue84a"),
		ic_photo_library("\ue84b"),
		ic_portrait("\ue84c"),
		ic_remove_red_eye("\ue84d"),
		ic_rotate_left("\ue84e"),
		ic_rotate_right("\ue84f"),
		ic_slideshow("\ue850"),
		ic_straighten("\ue851"),
		ic_style("\ue852"),
		ic_switch_camera("\ue853"),
		ic_switch_video("\ue854"),
		ic_tag_faces("\ue855"),
		ic_texture("\ue856"),
		ic_timelapse("\ue857"),
		ic_timer_3("\ue858"),
		ic_timer_10("\ue859"),
		ic_timer("\ue85a"),
		ic_timer_auto("\ue85b"),
		ic_timer_off("\ue85c"),
		ic_tonality("\ue85d"),
		ic_transform("\ue85e"),
		ic_tune("\ue85f"),
		ic_wb_auto("\ue860"),
		ic_wb_cloudy("\ue861"),
		ic_wb_incandescent("\ue862"),
		ic_wb_irradescent("\ue863"),
		ic_wb_sunny("\ue864"),
		ic_beenhere("\ue865"),
		ic_directions("\ue866"),
		ic_directions_bike("\ue867"),
		ic_directions_bus("\ue868"),
		ic_directions_car("\ue869"),
		ic_directions_ferry("\ue86a"),
		ic_directions_subway("\ue86b"),
		ic_directions_train("\ue86c"),
		ic_directions_transit("\ue86d"),
		ic_directions_walk("\ue86e"),
		ic_flight("\ue86f"),
		ic_hotel("\ue870"),
		ic_layers("\ue871"),
		ic_layers_clear("\ue872"),
		ic_local_airport("\ue873"),
		ic_local_atm("\ue874"),
		ic_local_attraction("\ue875"),
		ic_local_bar("\ue876"),
		ic_local_cafe("\ue877"),
		ic_local_car_wash("\ue878"),
		ic_local_convenience_store("\ue879"),
		ic_local_drink("\ue87a"),
		ic_local_florist("\ue87b"),
		ic_local_gas_station("\ue87c"),
		ic_local_grocery_store("\ue87d"),
		ic_local_hospital("\ue87e"),
		ic_local_hotel("\ue87f"),
		ic_local_laundry_service("\ue880"),
		ic_local_library("\ue881"),
		ic_local_mall("\ue882"),
		ic_local_movies("\ue883"),
		ic_local_offer("\ue884"),
		ic_local_parking("\ue885"),
		ic_local_pharmacy("\ue886"),
		ic_local_phone("\ue887"),
		ic_local_pizza("\ue888"),
		ic_local_play("\ue889"),
		ic_local_post_office("\ue88a"),
		ic_local_print_shop("\ue88b"),
		ic_local_restaurant("\ue88c"),
		ic_local_see("\ue88d"),
		ic_local_shipping("\ue88e"),
		ic_local_taxi("\ue88f"),
		ic_location_history("\ue890"),
		ic_map("\ue891"),
		ic_my_location("\ue892"),
		ic_navigation("\ue893"),
		ic_pin_drop("\ue894"),
		ic_place("\ue895"),
		ic_rate_review("\ue896"),
		ic_restaurant_menu("\ue897"),
		ic_satellite("\ue898"),
		ic_store_mall_directory("\ue899"),
		ic_terrain("\ue89a"),
		ic_traffic("\ue89b"),
		ic_apps("\ue89c"),
		ic_arrow_back("\ue89d"),
		ic_arrow_drop_down("\ue89e"),
		ic_arrow_drop_down_circle("\ue89f"),
		ic_arrow_drop_up("\ue8a0"),
		ic_arrow_forward("\ue8a1"),
		ic_cancel("\ue8a2"),
		ic_check("\ue8a3"),
		ic_chevron_left("\ue8a4"),
		ic_chevron_right("\ue8a5"),
		ic_close("\ue8a6"),
		ic_expand_less("\ue8a7"),
		ic_expand_more("\ue8a8"),
		ic_fullscreen("\ue8a9"),
		ic_fullscreen_exit("\ue8aa"),
		ic_menu("\ue8ab"),
		ic_more_horiz("\ue8ac"),
		ic_more_vert("\ue8ad"),
		ic_refresh("\ue8ae"),
		ic_unfold_less("\ue8af"),
		ic_unfold_more("\ue8b0"),
		ic_adb("\ue8b1"),
		ic_bluetooth_audio("\ue8b2"),
		ic_disc_full("\ue8b3"),
		ic_dnd_forwardslash("\ue8b4"),
		ic_do_not_disturb("\ue8b5"),
		ic_drive_eta("\ue8b6"),
		ic_event_available("\ue8b7"),
		ic_event_busy("\ue8b8"),
		ic_event_note("\ue8b9"),
		ic_folder_special("\ue8ba"),
		ic_mms("\ue8bb"),
		ic_more("\ue8bc"),
		ic_network_locked("\ue8bd"),
		ic_phone_bluetooth_speaker("\ue8be"),
		ic_phone_forwarded("\ue8bf"),
		ic_phone_in_talk("\ue8c0"),
		ic_phone_locked("\ue8c1"),
		ic_phone_missed("\ue8c2"),
		ic_phone_paused("\ue8c3"),
		ic_play_download("\ue8c4"),
		ic_play_install("\ue8c5"),
		ic_sd_card("\ue8c6"),
		ic_sim_card_alert("\ue8c7"),
		ic_sms("\ue8c8"),
		ic_sms_failed("\ue8c9"),
		ic_sync("\ue8ca"),
		ic_sync_disabled("\ue8cb"),
		ic_sync_problem("\ue8cc"),
		ic_system_update("\ue8cd"),
		ic_tap_and_play("\ue8ce"),
		ic_time_to_leave("\ue8cf"),
		ic_vibration("\ue8d0"),
		ic_voice_chat("\ue8d1"),
		ic_vpn_lock("\ue8d2"),
		ic_cake("\ue8d3"),
		ic_domain("\ue8d4"),
		ic_group("\ue8d5"),
		ic_group_add("\ue8d6"),
		ic_location_city("\ue8d7"),
		ic_mood("\ue8d8"),
		ic_notifications("\ue8d9"),
		ic_notifications_none("\ue8da"),
		ic_notifications_off("\ue8db"),
		ic_notifications_on("\ue8dc"),
		ic_notifications_paused("\ue8dd"),
		ic_pages("\ue8de"),
		ic_party_mode("\ue8df"),
		ic_people("\ue8e0"),
		ic_people_outline("\ue8e1"),
		ic_person("\ue8e2"),
		ic_person_add("\ue8e3"),
		ic_person_outline("\ue8e4"),
		ic_plus_one("\ue8e5"),
		ic_poll("\ue8e6"),
		ic_public("\ue8e7"),
		ic_school("\ue8e8"),
		ic_share("\ue8e9"),
		ic_whatshot("\ue8ea"),
		ic_check_box("\ue8eb"),
		ic_check_box_outline_blank("\ue8ec"),
		ic_radio_button_off("\ue8ed"),
		ic_radio_button_on("\ue8ee"),
		ic_star("\ue8ef"),
		ic_star_half("\ue8f0"),
		ic_star_outline("\ue8f1");
		
		String unicode;
		
		GoogleMaterialIcon(String unicode) {
			this.unicode = unicode;
		}
		
		public String getUnicode() {
			return unicode;
		}
		
	}
	
}