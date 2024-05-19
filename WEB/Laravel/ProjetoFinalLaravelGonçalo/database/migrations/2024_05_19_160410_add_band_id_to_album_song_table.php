<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('album_song', function (Blueprint $table) {
            $table->unsignedBigInteger('band_id');
            $table->foreign('band_id')->references('band_id')->on('albums');

        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('album_song', function (Blueprint $table) {
            $table->dropColumn('band_id');
        });
    }
};
