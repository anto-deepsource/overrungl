/*
 * MIT License
 *
 * Copyright (c) 2023 Overrun Organization
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

package overrungl.demo.nfd;

import overrungl.nfd.NFD;
import overrungl.nfd.NFDEnumerator;
import overrungl.nfd.NFDNFilterItem;
import overrungl.nfd.NFDResult;
import overrungl.util.MemoryStack;
import overrungl.util.value.Pair;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

/**
 * @author squid233
 * @since 0.1.0
 */
public final class NFDTest {
    private static void openDialog() {
        System.out.println("===== openDialog =====");
        // initialize NFD
        // either call NFD::init at the start of your program and NFD::quit at the end of your program,
        // or before/after every time you want to show a file dialog.
        NFD.init();

        try (MemoryStack stack = MemoryStack.stackPush()) {
            String[] outPath = new String[1];

            // prepare filters for the dialog
            final NFDNFilterItem.Buffer filterItem = NFDNFilterItem.create(stack,
                new Pair<>("Source code", "java"),
                new Pair<>("Image file", "png,jpg"));

            // show the dialog
            final NFDResult result = NFD.openDialogN(outPath, filterItem, null);

            switch (result) {
                case ERROR -> System.err.println(STR. "Error: \{ NFD.getError() }" );
                case OKAY -> System.out.println(STR. "Success! \{ outPath[0] }" );
                case CANCEL -> System.out.println("User pressed cancel.");
            }
        }

        // Quit NFD
        NFD.quit();
    }

    private static void openDialogMultiple() {
        System.out.println("===== openDialogMultiple =====");
        // initialize NFD
        // either call NFD::init at the start of your program and NFD::quit at the end of your program,
        // or before/after every time you want to show a file dialog.
        NFD.init();

        try (MemoryStack stack = MemoryStack.stackPush()) {
            MemorySegment pOutPaths = stack.callocPointer();
            String[] outPath = new String[1];

            // prepare filters for the dialog
            final NFDNFilterItem.Buffer filterItem = NFDNFilterItem.create(stack,
                new Pair<>("Source code", "java"),
                new Pair<>("Image file", "png,jpg"));

            // show the dialog
            final NFDResult result = NFD.openDialogMultipleN(pOutPaths, filterItem, null);
            MemorySegment outPaths = pOutPaths.get(ValueLayout.ADDRESS, 0);

            switch (result) {
                case ERROR -> System.err.println(STR. "Error: \{ NFD.getError() }" );
                case OKAY -> {
                    System.out.println("Success!");

                    for (long i = 0, numPaths = NFD.pathSetGetCount(outPaths).y(); i < numPaths; i++) {
                        NFD.pathSetGetPathN(outPaths, i, outPath);
                        System.out.println(STR. "Path \{ i }: \{ outPath[0] }" );
                    }

                    // remember to free the path-set memory (since NFDResult::OKAY is returned)
                    NFD.pathSetFree(outPaths);
                }
                case CANCEL -> System.out.println("User pressed cancel.");
            }
        }

        // Quit NFD
        NFD.quit();
    }

    private static void openDialogMultipleEnum() {
        System.out.println("===== openDialogMultipleEnum =====");
        // initialize NFD
        // either call NFD::init at the start of your program and NFD::quit at the end of your program,
        // or before/after every time you want to show a file dialog.
        NFD.init();

        try (MemoryStack stack = MemoryStack.stackPush()) {
            MemorySegment pOutPaths = stack.callocPointer();

            // prepare filters for the dialog
            final NFDNFilterItem.Buffer filterItem = NFDNFilterItem.create(stack,
                new Pair<>("Source code", "java"),
                new Pair<>("Image file", "png,jpg"));

            // show the dialog
            final NFDResult result = NFD.openDialogMultipleN(pOutPaths, filterItem, null);
            MemorySegment outPaths = pOutPaths.get(ValueLayout.ADDRESS, 0);

            switch (result) {
                case ERROR -> System.err.println(STR. "Error: \{ NFD.getError() }" );
                case OKAY -> {
                    System.out.println("Success!");

                    try (NFDEnumerator enumerator = NFDEnumerator.fromPathSetN(stack, outPaths).y()) {
                        int i = 0;
                        for (String path : enumerator) {
                            System.out.println(STR. "Path \{ i }: \{ path }" );
                            i++;
                        }
                    }

                    // remember to free the path-set memory (since NFDResult::OKAY is returned)
                    NFD.pathSetFree(outPaths);
                }
                case CANCEL -> System.out.println("User pressed cancel.");
            }
        }

        // Quit NFD
        NFD.quit();
    }

    private static void pickFolder() {
        System.out.println("===== pickFolder =====");
        // initialize NFD
        // either call NFD::init at the start of your program and NFD::quit at the end of your program,
        // or before/after every time you want to show a file dialog.
        NFD.init();

        try (MemoryStack stack = MemoryStack.stackPush()) {
            String[] outPath = new String[1];

            // show the dialog
            final NFDResult result = NFD.pickFolderN(outPath, null);
            switch (result) {
                case ERROR -> System.err.println(STR. "Error: \{ NFD.getError() }" );
                case OKAY -> System.out.println(STR. "Success! \{ outPath[0] }" );
                case CANCEL -> System.out.println("User pressed cancel.");
            }
        }

        // Quit NFD
        NFD.quit();
    }

    private static void saveDialog() {
        System.out.println("===== saveDialog =====");
        // initialize NFD
        // either call NFD::init at the start of your program and NFD::quit at the end of your program,
        // or before/after every time you want to show a file dialog.
        NFD.init();

        try (MemoryStack stack = MemoryStack.stackPush()) {
            String[] savePath = new String[1];

            // prepare filters for the dialog
            final NFDNFilterItem.Buffer filterItem = NFDNFilterItem.create(stack,
                new Pair<>("Source code", "java"),
                new Pair<>("Image file", "png,jpg"));

            // show the dialog
            final NFDResult result = NFD.saveDialogN(savePath, filterItem, null, "Untitled.java");
            switch (result) {
                case ERROR -> System.err.println(STR. "Error: \{ NFD.getError() }" );
                case OKAY -> System.out.println(STR. "Success! \{ savePath[0] }" );
                case CANCEL -> System.out.println("User pressed cancel.");
            }
        }

        // Quit NFD
        NFD.quit();
    }

    public static void main(String[] args) {
//        openDialog();
//        openDialogMultiple();
//        openDialogMultipleEnum();
//        pickFolder();
        saveDialog();
    }
}
